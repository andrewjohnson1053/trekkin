package com.example.trekkin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEditText;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    //Registration
    private EditText mFullName;
    private EditText mEmail;
    private EditText mPhone;
    private EditText mPassword;
    private EditText mUsername;
    private EditText mDob;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registration");

        mEditText = findViewById(R.id.edittext_dob_registration_activity);

        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mOnDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/" + dayOfMonth;
                mEditText.setText(date);
            }
        };

        //Registration

        mFullName = findViewById(R.id.edittext_name_registration_activity);
        mEmail = findViewById(R.id.edittext_email_registration_activity);
        mPhone = findViewById(R.id.edittext_phone_registration_activity);
        mPassword = findViewById(R.id.edittext_password_registration_activity);
        mUsername = findViewById(R.id.edittext_username_registration_activity);
        mDob = findViewById(R.id.edittext_dob_registration_activity);
        auth = FirebaseAuth.getInstance();

    }

    public void launchLoginActivity(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String fullName = mFullName.getText().toString();
        String phone = mPhone.getText().toString();
        String username = mUsername.getText().toString();
        String dob = mDob.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(fullName) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(username) || TextUtils.isEmpty(dob)){
            Toast.makeText(RegisterActivity.this, "Enter all the credentials!", Toast.LENGTH_SHORT).show();
        }else if (password.length() < 6){
            Toast.makeText(RegisterActivity.this, "Password is too short!", Toast.LENGTH_SHORT).show();
        }else{
            register(email, password);
        }
    }

    private void register(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("Name", mFullName.getText().toString());
                    map.put("Username", mUsername.getText().toString());
                    map.put("Email Address", mEmail.getText().toString());
                    map.put("Phone", mPhone.getText().toString());
                    map.put("Date of Birth", mDob.getText().toString());
                    FirebaseDatabase.getInstance().getReference().push().updateChildren(map);

                }else{
                    Toast.makeText(RegisterActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
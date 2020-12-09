package com.example.trekkin.ui.account;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.trekkin.LoginActivity;
import com.example.trekkin.R;
import com.google.firebase.auth.FirebaseAuth;

public class AccountFragment extends Fragment {

    private AccountViewModel mViewModel;
    private Button mLogoutButton;
    private FirebaseAuth auth;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        mLogoutButton = root.findViewById(R.id.button_logout);
        auth = FirebaseAuth.getInstance();

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        return root;
    }

    private void logoutUser() {
        auth.signOut();
        startActivity(new Intent(getContext(), LoginActivity.class));
        Toast.makeText(getContext(), "Logout Successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        // TODO: Use the ViewModel
    }

}
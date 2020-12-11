package com.example.trekkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

// variables
   // Animation logoanim, nameanim;
   // ImageView logo;
 //   TextView  name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        // Animations
       // logoanim = AnimationUtils.loadAnimation(this,R.anim.splashlogo_anim);
      //  nameanim = AnimationUtils.loadAnimation(this,R.anim.splashname_anim);

        // Hooks
      //  logo = findViewById(R.id.image);
      //  name = findViewById(R.id.text);

     //   logo.setAnimation(logoanim);
       // name.setAnimation(nameanim);

    }

}
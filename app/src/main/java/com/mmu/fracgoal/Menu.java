package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class Menu extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mAccountBtn, mGameBtn, mReferenceBtn;
    ImageView mSettingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAccountBtn = findViewById(R.id.accountPgBtn);
        mGameBtn = findViewById(R.id.gamePgBtn);
        mReferenceBtn = findViewById(R.id.referencePgBtn);
        mSettingBtn = findViewById(R.id.settingBtn);

        mAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        mGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mReferenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
}
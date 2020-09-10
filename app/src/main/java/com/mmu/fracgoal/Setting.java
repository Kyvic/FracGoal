package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {
    Button mUgBtn, mHelpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mUgBtn = findViewById(R.id.ugBtn);
        mHelpBtn = findViewById(R.id.helpBtn);

        mUgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), .class));
            }
        });

        mHelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), .class));
            }
        });

    }
}
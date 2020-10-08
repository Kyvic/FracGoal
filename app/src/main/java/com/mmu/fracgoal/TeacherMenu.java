package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TeacherMenu extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mAccountBtn, mReferenceBtn;
    ImageView mSettingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachermenu);

        mAccountBtn = findViewById(R.id.accountPgBtn);
        mReferenceBtn = findViewById(R.id.referencePgBtn);
        mSettingBtn = findViewById(R.id.settingBtn);

        mAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        mReferenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TeacherReference.class));
            }
        });

        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}

package com.mmu.fracgoal;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherReference extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mUploadVideoBtn, mUploadLearningMaterialBtn;
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherreference);

        mUploadVideoBtn = findViewById(R.id.uploadVideoBtn);
        mUploadLearningMaterialBtn = findViewById(R.id.uploadLearningMaterialBtn);
        mBack = findViewById(R.id.back13);

        mUploadVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UploadVideo.class));
            }
        });

        mUploadLearningMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UploadLearningMaterial.class));
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TeacherMenu.class));
            }
        });
    }
}

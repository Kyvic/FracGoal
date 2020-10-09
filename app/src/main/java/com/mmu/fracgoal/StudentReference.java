package com.mmu.fracgoal;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentReference extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mVideoBtn, mLearningMaterialBtn, mStaredExplanationBtn;
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentreference);

        mVideoBtn = findViewById(R.id.videoBtn);
        mLearningMaterialBtn = findViewById(R.id.materialBtn);
        mStaredExplanationBtn = findViewById(R.id.explainBtn);
        mBack = findViewById(R.id.back12);

        mVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), SearchVideo.class));
            }
        });

        mLearningMaterialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SearchLearningMaterial.class));
            }
        });

        mStaredExplanationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StarExplanation.class));
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Menu.class));
            }
        });
    }
}

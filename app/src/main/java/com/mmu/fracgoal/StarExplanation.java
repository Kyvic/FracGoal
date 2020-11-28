package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StarExplanation extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mEasyExp, mModerateExp, mHardExp;
    ImageView mBack;
    private EasyExplanation exp1 = new EasyExplanation();
    private ModerateExplanation exp2 = new ModerateExplanation();
    private HardExplanation exp3 = new HardExplanation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starexplanation);

        mEasyExp = findViewById(R.id.btnEasyExplanation);
        mModerateExp = findViewById(R.id.btnModerateExplanation);
        mHardExp = findViewById(R.id.btnHardExplanation);
        mBack = findViewById(R.id.back11);

        mEasyExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(exp1.getEasyExpStar()) {
                    startActivity(new Intent(getApplicationContext(), EasyExplanation.class));
                }
                else{
                    Toast.makeText(StarExplanation.this,"No starred the explanation of easy game.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mModerateExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(exp2.getModerateExpStar()) {
                    startActivity(new Intent(getApplicationContext(), ModerateExplanation.class));
                }
                else{
                    Toast.makeText(StarExplanation.this,"No starred the explanation of moderate game.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mHardExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(exp3.getHardExpStar()) {
                    startActivity(new Intent(getApplicationContext(), HardExplanation.class));
                }
                else{
                    Toast.makeText(StarExplanation.this,"No starred the explanation of hard game.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StudentReference.class));
            }
        });
    }
}


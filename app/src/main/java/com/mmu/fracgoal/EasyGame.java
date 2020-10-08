package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EasyGame extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mEasyAns1, mEasyAns2, mEasyAns3, mEasyAns4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easygame);

        mEasyAns1 = findViewById(R.id.easyAns1);
        mEasyAns2 = findViewById(R.id.easyAns2);
        mEasyAns3 = findViewById(R.id.easyAns3);
        mEasyAns4 = findViewById(R.id.easyAns4);

        mEasyAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EasyExplanation.class));
            }
        });

        mEasyAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EasyExplanation.class));
            }
        });

        mEasyAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EasyExplanation.class));
            }
        });

        mEasyAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WinGame1.class));
            }
        });
    }
}


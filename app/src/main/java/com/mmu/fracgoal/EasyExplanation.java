package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EasyExplanation extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mContinue;
    ImageView mStar;
    private static boolean easyExpStar;
    private StarExplanation model = new StarExplanation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easyexplanation);

        mContinue = findViewById(R.id.continueBtn1);
        mStar = findViewById(R.id.starImage1);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameMenu.class));
            }
        });

        mStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStar.hasOnClickListeners()) {
                    setEasyExpStar();
                    Toast.makeText(EasyExplanation.this, "Add to star explanation successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void setEasyExpStar(){
        easyExpStar = true;
    }

    public static boolean getEasyExpStar(){
        return easyExpStar;
    }
}
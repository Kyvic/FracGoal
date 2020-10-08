package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModerateExplanation extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mContinue;
    ImageView mStar;
    private static boolean moderateExpStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderateexplanation);

        mContinue = findViewById(R.id.continueBtn2);
        mStar = findViewById(R.id.starImage2);

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
                    setModerateExpStar();
                    Toast.makeText(ModerateExplanation.this, "Add to star explanation successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void setModerateExpStar(){
        moderateExpStar = true;
    }

    public static boolean getModerateExpStar(){
        return moderateExpStar;
    }
}
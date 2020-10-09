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
    ImageView mStar, mBack;
    private static boolean moderateExpStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderateexplanation);

        mStar = findViewById(R.id.starImage2);
        mBack = findViewById(R.id.back8);

        mStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStar.hasOnClickListeners()) {
                    setModerateExpStar();
                    Toast.makeText(ModerateExplanation.this, "Add to star explanation successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameMenu.class));
            }
        });
    }

    public static void setModerateExpStar(){ moderateExpStar = true; }

    public static boolean getModerateExpStar(){
        return moderateExpStar;
    }
}
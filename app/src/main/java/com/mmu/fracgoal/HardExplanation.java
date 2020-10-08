package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HardExplanation extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mEnd;
    ImageView mStar;
    private static boolean hardExpStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardexplanation);

        mEnd = findViewById(R.id.endBtn);
        mStar = findViewById(R.id.starImage3);

        mEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameMenu.class));
            }
        });

        mStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStar.hasOnClickListeners()) {
                    setHardExpStar();
                    Toast.makeText(HardExplanation.this, "Add to star explanation successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void setHardExpStar(){
        hardExpStar = true;
    }

    public static boolean getHardExpStar(){
        return hardExpStar;
    }
}
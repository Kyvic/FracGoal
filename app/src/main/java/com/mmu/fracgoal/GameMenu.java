package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameMenu extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button mEasyBtn, mModerateBtn, mHardBtn;
    boolean easySts = false;
    private WinGame1 model1 = new WinGame1();
    private WinGame2 model2 = new WinGame2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);

        mEasyBtn = findViewById(R.id.easyPgBtn);
        mModerateBtn = findViewById(R.id.moderatePgBtn);
        mHardBtn = findViewById(R.id.hardPgBtn);

        mEasyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EasyGame.class));
            }
        });

        mModerateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(model1.getEasyGameState()) {
                    startActivity(new Intent(getApplicationContext(), ModerateGame.class));
                }
                else{
                    Toast.makeText(GameMenu.this,"Win easy game! To proceed with moderate game", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mHardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(model2.getModerateGameState()) {
                    startActivity(new Intent(getApplicationContext(), HardGame.class));
                }
                else{
                    Toast.makeText(GameMenu.this,"Win moderate game! To proceed with hard game", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

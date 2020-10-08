package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WinGame2 extends AppCompatActivity {
    public static final String TAG = "TAG";
    private static boolean moderateGameState;
    Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wingame2);

        mContinue = findViewById(R.id.ctnbtn2);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mContinue.hasOnClickListeners()) {
                    setModerateGameState();
                    startActivity(new Intent(getApplicationContext(), GameMenu.class));
                }
            }
        });
    }

    public static void setModerateGameState(){
        moderateGameState = true;
    }

    public static boolean getModerateGameState(){
        return moderateGameState;
    }
}


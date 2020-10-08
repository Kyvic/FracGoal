package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WinGame1 extends AppCompatActivity {
    public static final String TAG = "TAG";
    private static boolean easyGameState;
    Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wingame1);

        mContinue = findViewById(R.id.ctnbtn1);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mContinue.hasOnClickListeners()) {
                    setEasyGameState();
                    startActivity(new Intent(getApplicationContext(), GameMenu.class));
                }
            }
        });
    }

    public static void setEasyGameState(){
        easyGameState = true;
    }

    public static boolean getEasyGameState(){
        return easyGameState;
    }
}


package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LearningProgress extends AppCompatActivity {
    private int progr = 0;
    ProgressBar mProgress;
    TextView mTextViewProg;
    ImageView mBack;
    private EasyGame win1 = new EasyGame();
    private ModerateGame win2 = new ModerateGame();
    private HardGame win3 = new HardGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningprogress);
        mProgress = findViewById(R.id.progress_bar);
        mTextViewProg = findViewById(R.id.text_view_progress);
        mBack = findViewById(R.id.back7);
        if(win1.getEasyGameState()){
            progr += 33;
        }
        if(win2.getModerateGameState()){
            progr += 33;
        }
        if(win3.getHardGameState()){
            progr += 34;
        }
        mProgress.setProgress(progr);
        mTextViewProg.setText(String.valueOf(progr) + "%");

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Account.class));
            }
        });
    }
}

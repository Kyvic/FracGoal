package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ModerateGame extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mModerateAns;
    Button mSubmitBtn;
    private static boolean moderateGameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderategame);

        mModerateAns = findViewById(R.id.editAnsModerate);
        mSubmitBtn = findViewById(R.id.submitBtn1);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = mModerateAns.getText().toString();

                if (TextUtils.isEmpty(ans)){
                    mModerateAns.setError("Answer is Required.");
                    return;
                }

                else if (ans.equals("45/7")){
                    setModerateGameState();
                    startActivity(new Intent(getApplicationContext(), WinGame2.class));
                }

                else{
                    startActivity(new Intent(getApplicationContext(), ModerateExplanation.class));
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


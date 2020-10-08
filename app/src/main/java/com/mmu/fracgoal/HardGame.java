package com.mmu.fracgoal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class HardGame extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mHardAns;
    Button mSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardgame);

        mHardAns = findViewById(R.id.editAnsHard);
        mSubmitBtn = findViewById(R.id.submitBtn2);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = mHardAns.getText().toString();

                if (TextUtils.isEmpty(ans)){
                    mHardAns.setError("Answer is Required.");
                    return;
                }

                else if (ans.equals("3/10") ||ans.equals("0.3")  ){
                    startActivity(new Intent(getApplicationContext(), WinGame3.class));
                }

                else{
                    System.out.println(ans);
                    startActivity(new Intent(getApplicationContext(), HardExplanation.class));
                }
            }
        });
    }
}


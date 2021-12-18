package com.ksh3023.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "com.ksh3023.gomin.answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        String answer = getIntent().getStringExtra(EXTRA_ANSWER);
        if (answer == null) {
            finish();
        }

        TextView answerTextView = findViewById(R.id.textViewAnswer);
        answerTextView.setText(answer);

        Button questionAgainButton = findViewById(R.id.buttonQuestionAgain);
        Button exitButton = findViewById(R.id.buttonExit);

        questionAgainButton.setOnClickListener(v -> finish());
        exitButton.setOnClickListener(v -> exitApp());
    }

    private void exitApp() {
        Intent intent = new Intent();
        intent.putExtra(QuestionActivity.EXTRA_EXIT, true);
        setResult(RESULT_OK, intent);
        finish();
    }

}




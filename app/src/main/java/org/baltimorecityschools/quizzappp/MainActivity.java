package org.baltimorecityschools.quizzappp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.baltimorecityschools.quizzappp.R;

public class MainActivity extends AppCompatActivity {

    Button trueButton, falseButton, nextButton, finishedButton;

    Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    TextView questionTV, questionNumberTV;
    Question currentQ;

    Question[] questionsBank;
    int currentNum;
    int score;

    boolean userAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1 = new Question(getString(R.string.q_Beethoven), true);
        q2 = new Question(getString(R.string.q_Mozart), false);
        q3 = new Question(getString(R.string.q_Handel), true);
        q4 = new Question(getString(R.string.q_Cello), false);
        q5 = new Question(getString(R.string.q_Vivaldi), true);
        q6 = new Question(getString(R.string.q_piano), false);
        q7 = new Question(getString(R.string.q_piccolo), true);
        q8 = new Question(getString(R.string.q_Bach), false);
        q9 = new Question(getString(R.string.q_forte), false);
        q10 = new Question(getString(R.string.q_Edvard), false);
        questionsBank = new Question[]{q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

        currentNum = 0;
        score = 0;
        currentQ = questionsBank[currentNum];

        questionTV = findViewById(R.id.questionText);
        questionNumberTV = findViewById(R.id.questionNumberText); // Connected XML ID to Java
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.nextButton);
        finishedButton = findViewById(R.id.finishedButton);

        // Sets the initial layout header text to "Question 1 of 10" when the app opens
        questionNumberTV.setText("Question " + (currentNum + 1) + " of " + questionsBank.length);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAns = true;
                if (userAns == currentQ.getcorrectAns()) {
                    Toast.makeText(MainActivity.this,
                            "You are right", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(MainActivity.this,
                            "You are wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAns = false;
                if (userAns == currentQ.getcorrectAns()) {
                    Toast.makeText(MainActivity.this,
                            "You are right", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(MainActivity.this,
                            "You are wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum < questionsBank.length - 1) {
                    Toast.makeText(MainActivity.this,
                            "Next question!", Toast.LENGTH_SHORT).show();
                    currentNum++;
                    currentQ = questionsBank[currentNum];

                    // Updates the question text
                    questionTV.setText(currentQ.getqPrompt());

                    // Updates the question number display dynamically (e.g. Question 2 of 10)
                    questionNumberTV.setText("Question " + (currentNum + 1) + " of " + questionsBank.length);
                } else {
                    Toast.makeText(MainActivity.this, "No more questions, click Finish Button", Toast.LENGTH_SHORT).show();
                }
            }
        });

        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishIntent = new Intent(MainActivity.this, ScoreActivity.class);
                finishIntent.putExtra("SCORE_KEY", score);
                finishIntent.putExtra("TOTAL_KEY", questionsBank.length);
                startActivity(finishIntent);
            }
        });
    }
}

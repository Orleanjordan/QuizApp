package org.baltimorecityschools.quizzappp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    Intent incoming;
    int numQ;
    int score;
    TextView scoreDisplayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        scoreDisplayTextView = findViewById(R.id.scoreDisplayTextView);
        numQ = 0;
        score = 0;
        incoming = getIntent();

        numQ = incoming.getIntExtra("TOTAL_KEY", 0);
        score = incoming.getIntExtra("SCORE_KEY", 0);
        scoreDisplayTextView.setText(score + "/" + numQ );










    }
}
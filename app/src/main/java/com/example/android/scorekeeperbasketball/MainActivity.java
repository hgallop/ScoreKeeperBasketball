package com.example.android.scorekeeperbasketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String SCORE_HOME = "scoreHome";
    private final String SCORE_VISITOR = "scoreVisitor";

    int scoreHome = 0;
    int scoreVisitor = 0;
    int score = 0;

    TextView homeScore;
    TextView visitorScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeScore = findViewById(R.id.home_score);
        visitorScore = findViewById(R.id.visitor_score);
    }

    /** Saves app data between states */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_HOME, scoreHome);
        outState.putInt(SCORE_VISITOR, scoreVisitor);
    }

    /** Restores app data on new state */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreHome = savedInstanceState.getInt(SCORE_HOME);
        scoreVisitor = savedInstanceState.getInt(SCORE_VISITOR);
    }

    /**
     * Resets both scores to 0
     */
    public void resetAll(View view) {
        scoreHome = 0;
        scoreVisitor = 0;
        displayForHome(scoreHome);
        displayForVisitor(scoreVisitor);
    }

    /**
     * Displays the given score for Home.
     */
    public void displayForHome(int score) {
        homeScore.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Visiting.
     */
    public void displayForVisitor(int score) {
        visitorScore.setText(String.valueOf(score));
    }

    /**
     * Calculates update for three point score. Displays updated score.
     */
    public void threePointsHome(View view) {
        score = 3;
        scoreHome = scoreHome + score;
        displayForHome(scoreHome);
    }

    public void threePointsVisitor(View view) {
        score = 3;
        scoreVisitor = scoreVisitor + score;
        displayForVisitor(scoreVisitor);
    }


    /**
     * Calculates update for two point score. Displays updated score.
     */
    public void twoPointsHome(View view) {
        score = 2;
        scoreHome = scoreHome + score;
        displayForHome(scoreHome);
    }

    public void twoPointsVisitor(View view) {
        score = 2;
        scoreVisitor = scoreVisitor + score;
        displayForVisitor(scoreVisitor);
    }


    /**
     * Calculates update for one point score. Displays updated score.
     */
    public void onePointHome(View view) {
        score = 1;
        scoreHome = scoreHome + score;
        displayForHome(scoreHome);
    }

    public void onePointVisitor(View view) {
        score = 1;
        scoreVisitor = scoreVisitor + score;
        displayForVisitor(scoreVisitor);
    }
}
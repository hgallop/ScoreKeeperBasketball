package com.example.android.scorekeeperbasketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  
    private final String SCORE_HOME = "scoreHome";
    private final String SCORE_VISITOR = "scoreVisitor";
    private final String HOME_NAME = "homeName";
    private final String VISITOR_NAME = "visitorName";

    Team homeTeam;
    Team visitorTeam;

    // Be descriptive in your variable names.  homeScoreTextView conveys more than homeScore (which sounds like an int)
    TextView homeScoreTextView;
    TextView visitorScoreTextView;
    TextView homeNameTextView;
    TextView visitorNameTextView;

    // Again choose your variable names better. The better the read, the easier they are to understand.
    String homeName;
    String visitorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeScoreTextView = findViewById(R.id.home_score);
        visitorScoreTextView = findViewById(R.id.visitor_score);
        homeNameTextView = findViewById(R.id.home_name);
        visitorNameTextView = findViewById(R.id.visitor_name);

        homeName = getResources().getString(R.string.home);
        visitorName = getResources().getString(R.string.visitor);

        homeTeam = new Team(0, homeName, homeScoreTextView, homeNameTextView);
        visitorTeam = new Team(0, visitorName, visitorScoreTextView, visitorNameTextView);


        home.displayName(home.getName());
        visitor.displayName(visitor.getName());

        homeTeam.displayScore(homeTeam.getScore());
        visitorTeam.displayScore(visitorTeam.getScore());
    }

    /** Saves app data between states */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_HOME, homeTeam.getScore());
        outState.putInt(SCORE_VISITOR, visitorTeam.getScore());
        outState.putString(HOME_NAME, homeTeam.getName());
        outState.putString(VISITOR_NAME, visitorTeam.getName());
    }

    /** Restores app data on new state screen rotation */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        homeTeam.setScore(savedInstanceState.getInt(SCORE_HOME));
        visitorTeam.setScore(savedInstanceState.getInt(SCORE_VISITOR));
        homeTeam.setName(savedInstanceState.getString(HOME_NAME));
        visitorTeam.setName(savedInstanceState.getString(VISITOR_NAME));
    }

    /**
     * Resets both scores to 0
     */
    public void resetAll(View view) {
        homeTeam.setScore(0);
        visitorTeam.setScore(0);
        homeTeam.displayScore(homeTeam.getScore());
        visitorTeam.displayScore(visitorTeam.getScore());
    }



    public void threePointsHome(View view) {
      homeTeam.threePoints(view);
    }

    public void threePointsVisitor(View view) {
       visitorTeam.threePoints(view);
    }


    /**
     * Calculates update for two point score. Displays updated score.
     */
    public void twoPointsHome(View view) {
        homeTeam.basket(view);
    }

    public void twoPointsVisitor(View view) {
       visitorTeam.basket(view);
    }


    /**
     * Calculates update for one point score. Displays updated score.
     */
    public void onePointHome(View view) {
        homeTeam.freeThrow(view);
    }

    public void onePointVisitor(View view) {
        visitorTeam.freeThrow(view);
    }
}
package com.example.android.scorekeeperbasketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // creates keys for save and restore state methods.
    static private final String SCORE_HOME = "scoreHome";
    static private final String SCORE_VISITOR = "scoreVisitor";
    static private final String HOME_NAME = "homeName";
    static private final String VISITOR_NAME = "visitorName";

    // creates variables for Team objects.
    Team homeTeam;
    Team visitorTeam;

    // creates variables for View calls.
    TextView homeScoreTextView;
    TextView visitorScoreTextView;
    TextView homeNameTextView;
    TextView visitorNameTextView;

    // creates variables for Team names.
    String homeName;
    String visitorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all views in one call
        homeScoreTextView = findViewById(R.id.home_score);
        visitorScoreTextView = findViewById(R.id.visitor_score);
        homeNameTextView = findViewById(R.id.home_name);
        visitorNameTextView = findViewById(R.id.visitor_name);

        //initialize name variables
        homeName = getResources().getString(R.string.home);
        visitorName = getResources().getString(R.string.visitor);

        //create Team objects
        homeTeam = new Team(0, homeName);
        visitorTeam = new Team(0, visitorName);

        //displays initial score and name
        displayNameHome(homeTeam.getName());
        displayNameVisitor(visitorTeam.getName());

        displayScoreHome(homeTeam.getScore());
        displayScoreVisitor(visitorTeam.getScore());
    }

    /** Saves app data between states screen rotation*/
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

    // method to display name for home team.
    public void displayNameHome(String name){
        homeNameTextView.setText(name);
    }

    // method to display name for visitor team.
    public void displayNameVisitor(String name){
        visitorNameTextView.setText(name);
    }

    // method to display home score.
    public void displayScoreHome(int score) {
        homeScoreTextView.setText(String.valueOf(score));
    }

    // method to display visitor score.
    public void displayScoreVisitor(int score) {
        visitorScoreTextView.setText(String.valueOf(score));
    }

    /**
     * Resets both scores to 0
     */
    public void resetAll(View view) {
        homeTeam.setScore(0);
        visitorTeam.setScore(0);
        displayScoreHome(homeTeam.getScore());
        displayScoreVisitor(visitorTeam.getScore());
    }

    /**
     * Calculates update for three point score. Displays updated score.
     */
    public void threePointsHome(View view) {
      homeTeam.threePoints();
      displayScoreHome(homeTeam.getScore());
    }

    public void threePointsVisitor(View view) {
       visitorTeam.threePoints();
       displayScoreVisitor(visitorTeam.getScore());
    }

    /**
     * Calculates update for two point score. Displays updated score.
     */
    public void twoPointsHome(View view) {
        homeTeam.basket();
        displayScoreHome(homeTeam.getScore());
    }

    public void twoPointsVisitor(View view) {
       visitorTeam.basket();
        displayScoreVisitor(visitorTeam.getScore());
    }

    /**
     * Calculates update for one point score. Displays updated score.
     */
    public void onePointHome(View view) {
        homeTeam.freeThrow();
        displayScoreHome(homeTeam.getScore());
    }

    public void onePointVisitor(View view) {
        visitorTeam.freeThrow();
        displayScoreVisitor(visitorTeam.getScore());
    }
}
package com.example.android.scorekeeperbasketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String SCORE_HOME = "scoreHome";
    private final String SCORE_VISITOR = "scoreVisitor";
    private final String HOME_NAME = "nameHome";
    private final String VISITOR_NAME = "nameVisitor";

    Team home;
    Team visitor;

    TextView homeScore;
    TextView visitorScore;
    TextView homeName;
    TextView visitorName;

    String nameHome;
    String nameVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeScore = findViewById(R.id.home_score);
        visitorScore = findViewById(R.id.visitor_score);
        homeName = findViewById(R.id.home_name);
        visitorName = findViewById(R.id.visitor_name);

        nameHome = getResources().getString(R.string.home);
        nameVisitor = getResources().getString(R.string.visitor);

        home = new Team(0, nameHome, homeScore, homeName);
        visitor = new Team(0, nameVisitor, visitorScore, visitorName);

        home.displayName(home.getName());
        visitor.displayName(visitor.getName());

        home.displayScore(home.getScore());
        visitor.displayScore(visitor.getScore());
    }

    /** Saves app data between states screen rotation*/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_HOME, home.getScore());
        outState.putInt(SCORE_VISITOR, visitor.getScore());
        outState.putString(HOME_NAME, home.getName());
        outState.putString(VISITOR_NAME, visitor.getName());
    }

    /** Restores app data on new state screen rotation */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        home.setScore(savedInstanceState.getInt(SCORE_HOME));
        visitor.setScore(savedInstanceState.getInt(SCORE_VISITOR));
        home.setName(savedInstanceState.getString(HOME_NAME));
        visitor.setName(savedInstanceState.getString(VISITOR_NAME));
    }

    /**
     * Resets both scores to 0
     */
    public void resetAll(View view) {
        home.setScore(0);
        visitor.setScore(0);
        home.displayScore(home.getScore());
        visitor.displayScore(visitor.getScore());
    }



    public void threePointsHome(View view) {
      home.threePoints(view);
    }

    public void threePointsVisitor(View view) {
       visitor.threePoints(view);
    }


    /**
     * Calculates update for two point score. Displays updated score.
     */
    public void twoPointsHome(View view) {
        home.basket(view);
    }

    public void twoPointsVisitor(View view) {
       visitor.basket(view);
    }


    /**
     * Calculates update for one point score. Displays updated score.
     */
    public void onePointHome(View view) {
        home.freeThrow(view);
    }

    public void onePointVisitor(View view) {
        visitor.freeThrow(view);
    }
}
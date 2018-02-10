package com.example.android.scorekeeperbasketball;

import android.view.View;
import android.widget.TextView;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    private int score;
    private String name;

    private TextView scoreDisplay;
    private TextView nameDisplay;

    // setup scoring
    final int THREEPOINTS = 3;
    final int BASKET = 2;
    final int FREETHROW =1 ;




    //Constructor
    public Team (int score, String name, TextView displayScore, TextView displayName) {
        this.score = score;
        this.name = name;
        scoreDisplay = displayScore;
        nameDisplay = displayName;
    }

    //mutator
    public void setName(String name){
        this.name = name;
    }

    //accessor
    public String getName() {
        return this.name;
    }

    //mutator
    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void displayName(String name){
        nameDisplay.setText(name);
    }

    public void displayScore(int score) {
        scoreDisplay.setText(String.valueOf(score));
    }

    public void threePoints(View view) {
        score += THREEPOINTS;
        displayScore(score);
    }

    public void basket(View view) {
        score += BASKET;
        displayScore(score);
    }

    public void freeThrow(View view) {
        score += FREETHROW;
        displayScore(score);
    }

}

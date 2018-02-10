package com.example.android.scorekeeperbasketball;

import android.view.View;
import android.widget.TextView;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    // variable names should be lowercase
    // Uppercase is typically reserved for things like classes.
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
        // when you use an external variable that uses the same name as an internal variable
        // you've created, you can use "this" to denote the internal one so you can assign
        // the external to the internal
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
    public void setScoreDisplay(TextView view){
        scoreDisplay = view;
    }

    //accessor
    public TextView getScoreDisplay(){
        return scoreDisplay;
    }

    //mutator
    public void setNameDisplay(TextView view){
        nameDisplay = view;
    }

    //accessor
    public TextView getNameDisplay(){
        return nameDisplay;
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

    // You should really consider creating constants for your scores opposed to using
    // "magic" numbers

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

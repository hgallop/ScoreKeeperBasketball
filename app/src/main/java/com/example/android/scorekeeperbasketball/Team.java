package com.example.android.scorekeeperbasketball;

import android.view.View;
import android.widget.TextView;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    private int Score;
    private String Name;

    private TextView ScoreDisplay;
    private TextView NameDisplay;

    //Constructor
    public Team (int score, String name, TextView displayScore, TextView displayName) {
        Score = score;
        Name = name;
        ScoreDisplay = displayScore;
        NameDisplay = displayName;
    }

    //mutator
    public void setName(String name){
        Name = name;
    }

    //accessor
    public String getName() {
        return Name;
    }

    //mutator
    public void setScoreDisplay(TextView view){
        ScoreDisplay = view;
    }

    //accessor
    public TextView getScoreDisplay(){
        return ScoreDisplay;
    }

    //mutator
    public void setNameDisplay(TextView view){
        NameDisplay = view;
    }

    //accessor
    public TextView getNameDisplay(){
        return NameDisplay;
    }

    //mutator
    public void setScore(int score){
        Score = score;
    }

    public int getScore(){
        return Score;
    }

    public void displayName(String name){
        NameDisplay.setText(name);
    }

    public void displayScore(int score) {
        ScoreDisplay.setText(String.valueOf(score));
    }

    public void threePoints(View view) {
        int ThreePointer = 3;
        Score = Score + ThreePointer;
        displayScore(Score);
    }

    public void basket(View view) {
        int Basket = 2;
        Score = Basket + Score;
        displayScore(Score);
    }

    public void freeThrow(View view) {
        int FreeThrow = 1;
        Score = FreeThrow + Score;
        displayScore(Score);
    }

}

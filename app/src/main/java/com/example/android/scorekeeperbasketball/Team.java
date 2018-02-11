package com.example.android.scorekeeperbasketball;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    // declares and initialize variables for scoring.
    static private final int THREEPOINTS = 3;
    static private final int BASKET = 2;
    static private final int FREETHROW =1 ;

    // declares variables for object
    private int score;
    private String name;

    // constructor method to create Team object.
    public Team (int score, String name) {
        this.score = score;
        this.name = name;
    }

    // mutator. allows name to be set.
    public void setName(String name){
        this.name = name;
    }

    // accessor. allows name to be accessed.
    public String getName() {
        return this.name;
    }

    // mutator. allows score to be set.
    public void setScore(int score){
        this.score = score;
    }

    // accessor. allows score to get accessed.
    public int getScore(){
        return this.score;
    }

    // method to score three points
    public void threePoints() {
        score += THREEPOINTS;
    }

    // method to score two points.
    public void basket() {
        score += BASKET;
    }

    // method to score one point.
    public void freeThrow() {
        score += FREETHROW;
    }

}

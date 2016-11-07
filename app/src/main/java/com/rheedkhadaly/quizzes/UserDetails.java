package com.rheedkhadaly.quizzes;

/**
 * Created by Rheed on 10/24/2016.
 */

public class UserDetails {

    private String name;
    private String gender;
    private int age;
    private int score;

    public UserDetails() {

    }

    public UserDetails(String name, String gender, int age, int score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public void setGender(String userGender) {
        this.gender = userGender;
    }

    public String getGener() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int userAge) {
        this.age = userAge;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int userScore) {
        this.score = userScore;
    }
}

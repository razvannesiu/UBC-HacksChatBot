package android.chatbot.com.chatbotapp;

/**
 * Created by razva on 2017-12-02.
 */

public class Submission {
    private String name;
    private String color;
    private String mood;
    private int score;

    private Submission(){

    }

    public Submission(String name, String color, String mood, int score) {
        this.color = color;
        this.mood = mood;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

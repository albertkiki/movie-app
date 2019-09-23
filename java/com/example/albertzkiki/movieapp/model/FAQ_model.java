package com.example.albertzkiki.movieapp.model;

/**
 * Created by albertzkiki on 4/10/2018.
 */

public class FAQ_model {

    private String id;
    private String question;
    private String answer;

    public FAQ_model() {
    }

    public FAQ_model(String id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

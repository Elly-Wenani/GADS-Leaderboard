package com.example.gads.Models;

public class iqModel {
    public String leanerNameIq;
    public int learnerIqScore;
    public String leanerCountryIq;
    public String leanerBudgeUrlIq;

    public iqModel(String leanerNameIq, int learnerIqScore, String leanerCountryIq, String leanerBudgeUrlIq) {
        this.leanerNameIq = leanerNameIq;
        this.learnerIqScore = learnerIqScore;
        this.leanerCountryIq = leanerCountryIq;
        this.leanerBudgeUrlIq = leanerBudgeUrlIq;
    }

    public String getLeanerNameIq() {
        return leanerNameIq;
    }

    public void setLeanerNameIq(String leanerNameIq) {
        this.leanerNameIq = leanerNameIq;
    }

    public int getLearnerIqScore() {
        return learnerIqScore;
    }

    public void setLearnerIqScore(int learnerIqScore) {
        this.learnerIqScore = learnerIqScore;
    }

    public String getLeanerCountryIq() {
        return leanerCountryIq;
    }

    public void setLeanerCountryIq(String leanerCountryIq) {
        this.leanerCountryIq = leanerCountryIq;
    }

    public String getLeanerBudgeUrlIq() {
        return leanerBudgeUrlIq;
    }

    public void setLeanerBudgeUrlIq(String leanerBudgeUrlIq) {
        this.leanerBudgeUrlIq = leanerBudgeUrlIq;
    }
}

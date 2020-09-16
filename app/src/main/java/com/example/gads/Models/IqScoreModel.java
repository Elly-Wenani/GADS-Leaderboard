package com.example.gads.Models;

import com.google.gson.annotations.SerializedName;

public class IqScoreModel {
    @SerializedName("name")
    public String leanerNameIq;
    @SerializedName("score")
    public int learnerIqScore;
    @SerializedName("country")
    public String leanerCountryIq;
    @SerializedName("badgeUrl")
    public String leanerBudgeUrlIq;

    public IqScoreModel(String leanerNameIq, int learnerIqScore, String leanerCountryIq, String leanerBudgeUrlIq) {
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

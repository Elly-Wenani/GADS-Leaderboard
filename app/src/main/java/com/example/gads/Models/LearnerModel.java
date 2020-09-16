package com.example.gads.Models;

import com.google.gson.annotations.SerializedName;

public class LearnerModel {
    @SerializedName("name")
    public String leanerName;
    @SerializedName("hours")
    public int learningHours;
    @SerializedName("country")
    public String leanerCountry;
    @SerializedName("badgeUrl")
    public String leanerBudgeUrl;

    public LearnerModel(String leanerName, int learningHours, String leanerCountry, String leanerBudgeUrl) {
        this.leanerName = leanerName;
        this.learningHours = learningHours;
        this.leanerCountry = leanerCountry;
        this.leanerBudgeUrl = leanerBudgeUrl;
    }

    public String getLeanerName() {
        return leanerName;
    }

    public void setLeanerName(String leanerName) {
        this.leanerName = leanerName;
    }

    public int getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(int learningHours) {
        this.learningHours = learningHours;
    }

    public String getLeanerCountry() {
        return leanerCountry;
    }

    public void setLeanerCountry(String leanerCountry) {
        this.leanerCountry = leanerCountry;
    }

    public String getLeanerBudgeUrl() {
        return leanerBudgeUrl;
    }

    public void setLeanerBudgeUrl(String leanerBudgeUrl) {
        this.leanerBudgeUrl = leanerBudgeUrl;
    }
}

package com.example.gads.Models;

public class LearnerModel {
    public String leanerName;
    public String learningHours;
    public String leanerCountry;
    public String leanerBudgeUrl;

    public LearnerModel(String leanerName, String learningHours, String leanerCountry, String leanerBudgeUrl) {
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

    public String getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(String learningHours) {
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

package com.example.enterfiance.model;

public class User {
    private String fullname;
    private String username;
    private String date;
    private String phoneNumber;
    private String sex;
    private String levelStudies;
    private String job;

    public User(String fullname, String username, String levelStudies, String job) {
        this.fullname = fullname;
        this.username = username;
        this.levelStudies = levelStudies;
        this.job = job;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevelStudies() {
        return levelStudies;
    }

    public void setLevelStudies(String levelStudies) {
        this.levelStudies = levelStudies;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

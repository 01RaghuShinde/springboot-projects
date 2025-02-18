package com.example.ChallengeApp;

public class Challenge {
    private Long id;
    private String month;
    private String Description;



    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }




}

package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatFact {

    public String getFact() {
        return Fact;
    }

    public void setFact(String fact) {
        Fact = fact;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    private String Fact;
    private String User;

    public CatFact() {
    }
}

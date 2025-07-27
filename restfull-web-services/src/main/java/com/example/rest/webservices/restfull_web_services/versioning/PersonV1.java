package com.example.rest.webservices.restfull_web_services.versioning;

public class PersonV1 {
    private String name;
    public PersonV1(String bobCharlie) {
        this.name = bobCharlie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

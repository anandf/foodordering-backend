package com.frontlinedubai.model;


import java.util.List;

public class Cuisine {
    private int id;

    private String name;

    private String description;

    private String image = "http://placehold.it/700x300";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {this.image = image;}

    public String getImage(){return this.image;}
}

package com.example.model;

public class Category extends BaseEntity{
    private String name;
    private String picture;

    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

}

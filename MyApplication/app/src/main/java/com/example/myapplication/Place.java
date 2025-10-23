package com.example.myapplication;

public class Place {
    private String name;
    private int imageResId; // or String imageUrl if using network

    public Place(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
}
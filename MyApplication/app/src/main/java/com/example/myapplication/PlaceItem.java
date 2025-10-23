package com.example.myapplication;
// PlaceItem.java
public class PlaceItem {
    private String name;
    private String location;
    private float rating;
    private int imageRes;

    public PlaceItem(String name, String location, float rating, int imageRes) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.imageRes = imageRes;
    }

    // Getters
    public String getName() { return name; }
    public String getLocation() { return location; }
    public float getRating() { return rating; }
    public int getImageRes() { return imageRes; }
}
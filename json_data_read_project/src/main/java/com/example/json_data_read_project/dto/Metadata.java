package com.example.json_data_read_project.dto;

public class Metadata {
    private String id;
    private String type;
    private double rating;
    private int reviews;

    // Constructor
    public Metadata() {}

    public Metadata(String id, String type, double rating, int reviews) {
        this.id = id;
        this.type = type;
        this.rating = rating;
        this.reviews = reviews;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getRating() {
        return rating;
    }

    public int getReviews() {
        return reviews;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    // toString Method
    @Override
    public String toString() {
        return "Metadata{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                '}';
    }
}

package com.example.json_data_read_project.dto;

public class Location {
    private String id;
    private double latitude;
    private double longitude;

    // Constructor
    public Location() {}

    public Location(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // toString Method
    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

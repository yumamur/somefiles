package com.yumamur.usersystem;

import java.util.Objects;

public class CityCoordinates {
    private double lat;
    private double lon;

    public CityCoordinates() {
    }

    public CityCoordinates(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
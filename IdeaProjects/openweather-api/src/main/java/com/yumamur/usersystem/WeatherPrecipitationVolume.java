package com.yumamur.usersystem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherPrecipitationVolume {
    @JsonProperty(value = "3h")
    private double h;

    public WeatherPrecipitationVolume() {
    }

    public WeatherPrecipitationVolume(double h3) {
        this.h = h3;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
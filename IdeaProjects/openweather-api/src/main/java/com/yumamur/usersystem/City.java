package com.yumamur.usersystem;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.annotation.AliasFor;

import java.util.Map;

public class City {
    @JsonProperty(value = "name", required = true)
    private String name;
    @JsonProperty("local_names")
    private Map<String, String> localNames;
    @JsonProperty(value = "lat", required = true)
    private Double lat;
    @JsonProperty(value = "lon", required = true)
    private Double lon;
    @JsonProperty(value = "country", required = true)
    private String country;
    @JsonProperty(value = "state")
    private String state;

    public City(){
    }
    public City(String name, Map<String, String> localNames, Double lat, Double lon, String country, String state) {
        this.name = name;
        this.localNames = localNames;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }
    public CityCoordinates getCoord() {
        return new CityCoordinates(lat, lon);
    }
    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public void setLocalNames(Map<String, String> localNames) {
        this.localNames = localNames;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }


    public Double getLon() {
        return lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

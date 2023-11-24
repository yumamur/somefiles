package com.yumamur.usersystem;

public class WeatherCity {
    private long id;
    private String name;
    private CityCoordinates coord;
    private String country;
    private int population;
    private int timezone;
    private Long sunrise;
    private Long sunset;

    public WeatherCity() {
    }

    public WeatherCity(
            long id,
            String name,
            CityCoordinates coord,
            String country,
            int population,
            int timezone,
            Long sunrise,
            Long sunset
    ) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityCoordinates getCoord() {
        return coord;
    }

    public void setCoord(CityCoordinates coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}
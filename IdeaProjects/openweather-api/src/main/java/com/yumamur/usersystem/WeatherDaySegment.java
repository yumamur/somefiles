package com.yumamur.usersystem;

import java.util.List;

public class WeatherDaySegment {
    private Long dt;
    private WeatherData main;
    private List<WeatherCondition> weather;
    private WeatherClouds clouds;
    private WeatherWind wind;
    private int visibility;
    private double pop;
    private WeatherPrecipitationVolume rain;
    private WeatherPrecipitationVolume snow;
    private WeatherSys sys;
    private String dt_txt;

    public WeatherDaySegment() {
    }

    public WeatherDaySegment(
            Long dt,
            WeatherData main,
            List<WeatherCondition> weather,
            WeatherClouds clouds,
            WeatherWind wind,
            int visibility,
            double pop,
            WeatherPrecipitationVolume rain,
            WeatherPrecipitationVolume snow,
            WeatherSys sys,
            String dt_txt
    ) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.rain = rain;
        this.snow = snow;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public WeatherData getMain() {
        return main;
    }

    public void setMain(WeatherData main) {
        this.main = main;
    }

    public List<WeatherCondition> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherCondition> weather) {
        this.weather = weather;
    }

    public WeatherClouds getClouds() {
        return clouds;
    }

    public void setClouds(WeatherClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherWind getWind() {
        return wind;
    }

    public void setWind(WeatherWind wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public WeatherPrecipitationVolume getRain() {
        return rain;
    }

    public void setRain(WeatherPrecipitationVolume rain) {
        this.rain = rain;
    }

    public WeatherPrecipitationVolume getSnow() {
        return snow;
    }

    public void setSnow(WeatherPrecipitationVolume snow) {
        this.snow = snow;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
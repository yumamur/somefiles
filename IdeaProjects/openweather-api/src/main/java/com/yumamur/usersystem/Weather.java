package com.yumamur.usersystem;

import java.util.List;

public class Weather {
    private String cod;
    private int message;
    private int cnt;
    private List<WeatherDaySegment> list;
    private WeatherCity city;

    public Weather() {
    }
    public Weather(String cod, int message, int cnt, List<WeatherDaySegment> list, WeatherCity city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherDaySegment> getList() {
        return list;
    }

    public void setList(List<WeatherDaySegment> list) {
        this.list = list;
    }

    public WeatherCity getCity() {
        return city;
    }

    public void setCity(WeatherCity city) {
        this.city = city;
    }
}
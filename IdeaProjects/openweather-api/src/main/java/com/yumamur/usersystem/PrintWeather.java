package com.yumamur.usersystem;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/weather")
public class PrintWeather {
    private final String apiKey = "2e8288edeef5e13e35382979c897499a";
    @GetMapping
    private ResponseEntity<Weather> printer(
            @RequestParam(required = false, value = "city")
            String city,
            @RequestParam(required = false, value = "country")
            String country
    ){
        if (city == null || country == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<City[]> responseCity =
                restTemplate.getForEntity(apiCity(String.join(city, country)), City[].class);
        return restTemplate
                .getForEntity(
                        apiWeather(
                                Objects.requireNonNull(responseCity.getBody())[0]
                                        .getCoord()
                        ),
                        Weather.class);
    }
    private String apiCity(String city) {
        return "https://api.openweathermap.org/geo/1.0/direct"
                + "?q=" + city
                + "&limit=" + "1"
                + "&appid=" + apiKey;
    }
    private String apiWeather(CityCoordinates coordinates) {
        return"https://api.openweathermap.org/data/2.5/forecast"
                + "?lat=" + coordinates.getLat()
                + "&lon=" + coordinates.getLon()
                + "&appid=" + apiKey;
    }
}

package com.weather.service.controller;

import com.weather.service.domain.CurrentWeather;
import com.weather.service.domain.WeatherForecast;
import com.weather.service.domain.WeatherDAO;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sindhya on 11/25/16.
 */

@RestController
public class WeatherServiceController {


    @RequestMapping(value="/weather/today/{location}",method= RequestMethod.GET)
    public CurrentWeather getCurrentWeather(@PathVariable("location") String location){

        WeatherDAO weatherDAO=new WeatherDAO();
        CurrentWeather currentWeatherResponse =weatherDAO.currentWeatherData(location);
        return currentWeatherResponse;

    }

    @RequestMapping(value = "weather/forecast/{location}",method=RequestMethod.GET)
    public WeatherForecast getForecastWeather(@PathVariable("location") String location){
        WeatherDAO  weatherDAO=new WeatherDAO();
        WeatherForecast forecastWeatherResponse=weatherDAO.forecastWeatherData(location);
        return  forecastWeatherResponse;

    }

}

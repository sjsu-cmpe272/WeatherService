package com.weather.service.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.weather.service.openweather.WeatherAPI;

import java.io.IOException;

/**
 * Created by sindhya on 11/26/16.
 */
public class WeatherDAO {


    public CurrentWeather currentWeatherData(String location){
        WeatherAPI weatherAPI=new WeatherAPI();
        String weatherResponse= weatherAPI.currentWeather(location);

        CurrentWeather currentWeather =null;
        String outputResponse=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {

            currentWeather =objectMapper.readValue(weatherResponse,CurrentWeather.class);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
            //outputResponse=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(businessRegion);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentWeather;
    }

    public WeatherForecast forecastWeatherData(String location){

        WeatherAPI weatherAPI=new WeatherAPI();
        String weatherResponse= weatherAPI.forecastWeather(location);

        WeatherForecast forecastWeather =null;
        String outputResponse=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {

            forecastWeather =objectMapper.readValue(weatherResponse,WeatherForecast.class);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
            //outputResponse=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(businessRegion);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return forecastWeather;

    }

}

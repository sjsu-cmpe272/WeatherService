package com.weather.service.openweather;

/**
 * Created by sindhya on 11/25/16.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeatherAPI {


    public String currentWeather(String location){

        StringBuffer result=null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(WeatherConstants.CURRENT_WEATHER_BASE_URL + location + "&APPID=" + WeatherConstants.API_KEY);
            HttpResponse response = client.execute(request);
            BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            result = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return result.toString();

    }

    public String forecastWeather(String location){

        StringBuffer result=null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(WeatherConstants.FORECAST_WEATHER_BASE_URL + location + "&APPID=" + WeatherConstants.API_KEY);
            HttpResponse response = client.execute(request);
            BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            result = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return result.toString();

    }


}

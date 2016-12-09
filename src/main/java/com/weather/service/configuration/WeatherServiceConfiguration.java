package com.weather.service.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by sindhya on 11/25/16.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.weather.service")
public class WeatherServiceConfiguration {

}

package com.apple.assessment.retton.service.weather;


import com.apple.assessment.retton.model.Weather;
import com.apple.assessment.retton.service.weather.AppleWeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RettonWeatherService implements AppleWeatherService {

    private RestTemplate webCommunicator;

    @Override
    public Weather getWeather(String city) {

        // webCommunicator get weather from a weather service

        Weather testWeather = new Weather("77F");
        return testWeather;
    }
}

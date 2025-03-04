package com.apple.assessment.retton.service.weather;


import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RettonWeatherService implements AppleWeatherService {

    private static final String WEATHER_API_KEY = "059a592634374f20972212717250403";

    private static final String WEATHER_API_URL = "http://api.weatherapi.com/v1/current.json";

    private static RestTemplate webCommunicator = new RestTemplate();

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Weather getWeather(Address address) throws IOException {

        String postalCode = address.getPostalCode();

        String weatherAPIRequestParameters = "?key=" + WEATHER_API_KEY + "&q=" + postalCode;

        ResponseEntity<String> weatherAPIServiceResponse = webCommunicator.getForEntity(WEATHER_API_URL + weatherAPIRequestParameters, String.class);

        JsonNode responseBodyRoot = objectMapper.readTree(weatherAPIServiceResponse.getBody());

        JsonNode currentWeatherData = responseBodyRoot.path("current");
        String currentTemperatureInFJson = currentWeatherData.get("temp_f").asText();

        Weather weather = new Weather(currentTemperatureInFJson);

        return weather;
    }
}

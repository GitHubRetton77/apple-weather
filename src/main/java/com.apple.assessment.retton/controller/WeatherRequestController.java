package com.apple.assessment.retton.controller;

import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import com.apple.assessment.retton.service.cache.AppleWeatherCache;
import com.apple.assessment.retton.service.weather.AppleWeatherService;
import com.apple.assessment.retton.utility.validation.AddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The controller shows the high level flow.
 * It should read like a system block diagram.
 * No implementation details.
 */
@RestController
@RequestMapping("/weather")
public class WeatherRequestController {

    @Autowired
    private AppleWeatherCache weatherCache;

    @Autowired
    private AppleWeatherService weatherService;

    private Logger logger = LoggerFactory.getLogger(WeatherRequestController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    private Weather getWeather(@RequestBody Address address) throws Exception {

        // log start of request processing
        logger.info("Get weather request received with address:\n", address);

        // Validate Request
        boolean isValidAddress = AddressValidator.isAddressValid(address);
        if(!isValidAddress){
            logger.error("Failed to get weather - bad address: \n", address);
            throw new Exception("Address is not valid.");
        }

        // Get weather from cache if available
        Weather cachedWeather = weatherCache.getWeather(address);
        if(cachedWeather != null){
            return cachedWeather;
        }

        // Get weather from external service
        Weather weather = weatherService.getWeather(address.getCity());

        // Cache weather
        weatherCache.cacheWeather(weather);

        // Log request result
        logger.info("Getting of weather successful! ^_^");

        return weather;
    }

}

package com.apple.assessment.retton.service.cache;

import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class RettonWeatherCache implements AppleWeatherCache {

    @Override
    public void cacheWeather(Weather weather) {

    }

    @Override
    public Weather getWeather(Address address) {
        return null;
    }
}

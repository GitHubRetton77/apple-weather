package com.apple.assessment.retton.service.cache;

import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;

public interface AppleWeatherCache {

    void cacheWeather(Address address, Weather weather);

    Weather getWeather(Address address);
}

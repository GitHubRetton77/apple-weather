package com.apple.assessment.retton.service.weather;

import com.apple.assessment.retton.model.Weather;
import org.springframework.stereotype.Service;

public interface AppleWeatherService {

    public Weather getWeather(String city);
}

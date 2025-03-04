package com.apple.assessment.retton.service.weather;

import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface AppleWeatherService {

    public Weather getWeather(Address address) throws IOException;
}

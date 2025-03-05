package com.apple.assessment.retton.service.cache;

import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RettonWeatherCache implements AppleWeatherCache {

    @Autowired
    private RedisTemplate<String, Weather> redisOperator;

    @Override
    public void cacheWeather(Address address, Weather weather) {
        String cacheKey = buildCacheKeyFromAddress(address);
        redisOperator.opsForValue().set(cacheKey, weather);

    }

    @Override
    public Weather getWeather(Address address) {
        String cacheKey = buildCacheKeyFromAddress(address);
        return redisOperator.opsForValue().get(cacheKey);
    }

    public static String buildCacheKeyFromAddress(Address address){
        return address.getCountry() + "_" + address.getCity() + "_" + address.getPostalCode();
    }
}

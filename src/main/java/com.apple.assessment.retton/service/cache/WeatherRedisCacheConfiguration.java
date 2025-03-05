package com.apple.assessment.retton.service.cache;

import com.apple.assessment.retton.model.Weather;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
@EnableCaching
public class WeatherRedisCacheConfiguration {

    private static final int WEATHER_CACHE_LIFESPAN = 30; // In minutes;

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(WEATHER_CACHE_LIFESPAN));
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaults)
                .build();
    }

    @Bean
    public RedisTemplate<String, Weather> redisTemplate() {
        RedisTemplate<String, Weather> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

}

package com.apple.assessment.retton.service.weather;

import com.apple.assessment.retton.RettonAssessment;
import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RettonAssessment.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RettonWeatherServiceTest {

    @Autowired
    private AppleWeatherService weatherService;

    @Test
    public void getWeather_Successful() throws IOException {


        Address address = new Address("2631 E Charleston Ave",
                "",
                "Phoenix",
                "Arizona",
                "85032",
                "US");
        Weather weather = weatherService.getWeather(address);

        assertNotNull(weather);
    }

    @Test
    public void getWeather_Failure() {

        Address address = new Address("fdsfadsfas",
                "",
                "fasxanlli",
                "lkkuok",
                "XXXXX",
                "US");
        try {
            weatherService.getWeather(address);
            fail();
        } catch (Exception exception) {
            assertTrue(exception instanceof HttpClientErrorException);
        }

    }
}
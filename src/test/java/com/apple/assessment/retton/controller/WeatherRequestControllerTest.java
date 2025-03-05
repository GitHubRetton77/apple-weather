package com.apple.assessment.retton.controller;

import com.apple.assessment.retton.RettonAssessment;
import com.apple.assessment.retton.model.Address;
import com.apple.assessment.retton.model.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RettonAssessment.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherRequestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void getWeather_Successful(){

        Address address = new Address("2631 E Charleston Ave",
                "",
                "Phoenix",
                "Arizona",
                "85032",
                "US");
        HttpEntity<Address> request = new HttpEntity<>(address, new HttpHeaders());

        ResponseEntity<Weather> response = restTemplate.exchange(
                "http://localhost:" + port + "/weather/get/",
                HttpMethod.GET,
                request,
                Weather.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Weather weatherData = response.getBody();

        assertNotNull(weatherData);
        assertNotNull(weatherData.getCurrentTemperature());

    }

    @Test
    public void getWeather_Failure(){

        Address address = new Address("bad",
                "",
                "bad",
                "bad",
                "bad",
                "bad");
        HttpEntity<Object> request = new HttpEntity<>(address);

        ResponseEntity<Weather> response = restTemplate.exchange(
                "http://localhost:" + port + "/weather/get/",
                HttpMethod.GET,
                request,
                Weather.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        Weather weatherData = response.getBody();

        assertNotNull(weatherData);
        assertNull(weatherData.getCurrentTemperature());

    }

}
package com.apple.assessment.retton.model;

public class Weather {

    private String currentTemperature;

    public Weather(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }
}

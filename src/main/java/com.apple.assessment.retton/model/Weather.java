package com.apple.assessment.retton.model;

import java.io.Serializable;

public class Weather implements Serializable {

    private String currentTemperature;

    public Weather(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }
}

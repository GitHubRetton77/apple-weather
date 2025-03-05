package com.apple.assessment.retton.model;

import java.io.Serializable;

public class Weather implements Serializable {

    private String currentTemperature;
    private boolean isFromCache = false;

    public Weather(){
    }

    public Weather(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setFromCache(boolean fromCache) {
        isFromCache = fromCache;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public boolean isFromCache() {
        return isFromCache;
    }
}

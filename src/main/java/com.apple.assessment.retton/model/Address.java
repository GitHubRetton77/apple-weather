package com.apple.assessment.retton.model;

import java.io.Serializable;

public class Address implements Serializable {

    private String street;
    private String supplementaryStreetDetails;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(){
    }

    public Address(String street, String supplementaryStreetDetails, String city, String state, String postalCode, String country) {
        this.street = street;
        this.supplementaryStreetDetails = supplementaryStreetDetails;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSupplementaryStreetDetails(String supplementaryStreetDetails) {
        this.supplementaryStreetDetails = supplementaryStreetDetails;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getSupplementaryStreetDetails() {
        return supplementaryStreetDetails;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return street + "," + supplementaryStreetDetails + "," + city + "," + postalCode + "," + country;
    }
}

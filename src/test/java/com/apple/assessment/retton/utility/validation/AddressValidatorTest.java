package com.apple.assessment.retton.utility.validation;

import com.apple.assessment.retton.model.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressValidatorTest {

    @Test
    public void isAddressValid_Good() {
        
        Address goodAddress = new Address("street", 
                "supplementaryStreetDetails",
                "city",
                "state",
                "postalCode",
                "country");

        boolean isValidAddress = AddressValidator.isAddressValid(goodAddress);

        assertTrue(isValidAddress);
    }

    @Test
    public void isAddressValid_BadCountry_Null(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                "city",
                "state",
                "postalCode",
                null);

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }

    @Test
    public void isAddressValid_BadCountry_Empty(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                "city",
                "state",
                "postalCode",
                "");

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }

    @Test
    public void isAddressValid_BadCity_Null(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                null,
                "state",
                "postalCode",
                "country");

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }

    @Test
    public void isAddressValid_BadCity_Empty(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                "",
                "state",
                "postalCode",
                "country");

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }

    @Test
    public void isAddressValid_BadPostalCode_Null(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                "cty",
                "state",
                null,
                "country");

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }

    @Test
    public void isAddressValid_BadPostalCode_Empty(){
        Address badAddress = new Address("street",
                "supplementaryStreetDetails",
                "cty",
                "state",
                "",
                "country");

        boolean isValidAddress = AddressValidator.isAddressValid(badAddress);

        assertFalse(isValidAddress);
    }
}
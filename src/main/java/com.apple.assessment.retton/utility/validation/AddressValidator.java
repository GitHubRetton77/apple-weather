package com.apple.assessment.retton.utility.validation;

import com.apple.assessment.retton.model.Address;

public class AddressValidator {

    public static boolean isAddressValid(Address address){
        boolean validCountry = (address.getCountry() != null && !address.getCountry().isEmpty());
        boolean validCity = (address.getCity() != null && !address.getCity().isEmpty());
        return validCountry && validCity;
    }
}

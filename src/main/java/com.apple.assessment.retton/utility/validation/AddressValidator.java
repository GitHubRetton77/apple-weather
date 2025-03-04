package com.apple.assessment.retton.utility.validation;

import com.apple.assessment.retton.model.Address;

public class AddressValidator {

    public static boolean isAddressValid(Address address){
        boolean isValidCountry = (address.getPostalCode() != null && !address.getPostalCode().isEmpty());
        boolean isValidCity = (address.getCity() != null && !address.getCity().isEmpty());
        boolean isValidPostalCode = (address.getPostalCode() != null && !address.getPostalCode().isEmpty());

        return isValidCountry && isValidCity && isValidPostalCode;
    }
}

package com.karina.icafe.bo;

public class Validator {

    public boolean validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateCupQuantity(int quantity) {
        if (quantity <= 0 || quantity > 1000) {
            return false;
        }
        else {
            return true;
        }
    }
}

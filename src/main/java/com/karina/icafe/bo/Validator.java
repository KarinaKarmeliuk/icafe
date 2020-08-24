package com.karina.icafe.bo;

public class Validator {

    public boolean validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            // not accept -> outside: inform user
            return false;
        } else {
            return true;
        }
    }

    public boolean validateCupQuantity(int quantity) {
        if (quantity < 0 || quantity > 1000) {
            //throw new NumberFormatException (?) -> outside: inform user
            return false;
        }
        else if (quantity > 0) {
            return true;
        }
        else
        {
            return false;
        }
    }
}

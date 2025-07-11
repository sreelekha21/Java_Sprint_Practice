package com.donateconnect.util;


import com.donateconnect.exception.InvalidInputException;

public class InputValidator {

    public static void validateQuantity(int quantity) throws InvalidInputException
    {
        if (quantity <= 0) {
            throw new InvalidInputException("Quantity must be greater than zero.");
        }
    }

    public static void validateString(String input) throws InvalidInputException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException("Input cannot be blank.");
        }
    }
}

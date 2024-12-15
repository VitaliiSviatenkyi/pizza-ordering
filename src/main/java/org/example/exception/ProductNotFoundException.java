package org.example.exception;

public class ProductNotFoundException extends IllegalArgumentException {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

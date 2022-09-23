package com.capitole_consulting.challenge.exception;

public class PriceNotFoundException extends DomainNotFoundException {

    public PriceNotFoundException(String message) {
        super(String.format("Not Found Price for %s", message));
    }

}

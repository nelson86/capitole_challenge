package com.capitole_consulting.challenge.exception;

import lombok.Getter;

@Getter
public class DomainNotFoundException extends RuntimeException {

    public DomainNotFoundException(String message) {
        super(message);
    }
}

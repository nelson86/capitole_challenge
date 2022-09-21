package com.capitole_consulting.challenge.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class PriceId {
    String value;

    public PriceId(String value) {
        this.value = value;
    }

    public static PriceId create() {
        return new PriceId(UUID.randomUUID().toString());
    }
}

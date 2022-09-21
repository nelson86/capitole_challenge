package com.capitole_consulting.challenge.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class PriceListId {
    String value;

    public PriceListId(String value) {
        this.value = value;
    }

    public static PriceListId create() {
        return new PriceListId(UUID.randomUUID().toString());
    }
}

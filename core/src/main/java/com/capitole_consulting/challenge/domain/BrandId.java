package com.capitole_consulting.challenge.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class BrandId {
    String value;

    public BrandId(String value) {
        this.value = value;
    }

    public static BrandId create() {
        return new BrandId(UUID.randomUUID().toString());
    }
}

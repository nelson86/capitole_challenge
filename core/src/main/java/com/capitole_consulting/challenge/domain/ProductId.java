package com.capitole_consulting.challenge.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class ProductId {
    String value;

    public ProductId(String value) {
        this.value = value;
    }

    public static ProductId create() {
        return new ProductId(UUID.randomUUID().toString());
    }
}

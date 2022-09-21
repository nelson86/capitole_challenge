package com.capitole_consulting.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private PriceId id;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private PriceList priceList;
    private Product product;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}

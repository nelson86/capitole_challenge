package com.capitole_consulting.challenge.controller;

import com.capitole_consulting.challenge.dto.PriceOfProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("v1/prices")
public class GetPriceOfProductController {

    @GetMapping
    public PriceOfProductDto getPriceOfProduct(
        @RequestParam(value = "applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime applicationDate,
        @RequestParam(value = "productId") Long productId,
        @RequestParam(value = "brandId") Long brandId
    ){
        log.info("Params: applicationDate: {}, productId: {}, brandId: {}", applicationDate, productId, brandId);
        return PriceOfProductDto.builder()
                .productId(35455L)
                .brandId(1L)
                .priceListId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .price(BigDecimal.valueOf(35.50))
                .build();
    }

}

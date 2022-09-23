package com.capitole_consulting.challenge.controller;

import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.dto.PriceOfProductDto;
import com.capitole_consulting.challenge.service.GetPriceOfProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("v1/prices")
public class GetPriceOfProductController {

    @Autowired
    private GetPriceOfProductService getPriceOfProductService;

    @GetMapping
    public PriceOfProductDto getPriceOfProduct(
        @RequestParam(value = "applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime applicationDate,
        @RequestParam(value = "productId") Long productId,
        @RequestParam(value = "brandId") Long brandId
    ){
        log.info("Params: applicationDate: {}, productId: {}, brandId: {}", applicationDate, productId, brandId);

        Price price = this.getPriceOfProductService.getPriceOfProduct(applicationDate, productId, brandId);

        return PriceOfProductDto.builder()
                .productId(price.getProductId())
                .brandId(price.getBrand().getId())
                .priceListId(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPriceValue())
                .build();
    }

}

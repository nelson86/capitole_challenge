package com.capitole_consulting.challenge.service;

import com.capitole_consulting.challenge.domain.Price;

import java.time.LocalDateTime;

public interface GetPriceOfProductService {

    Price getPriceOfProduct(LocalDateTime applicationDate, Long productId, Long brandId);

}

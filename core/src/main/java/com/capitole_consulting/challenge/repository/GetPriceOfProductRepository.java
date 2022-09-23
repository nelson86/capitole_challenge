package com.capitole_consulting.challenge.repository;

import com.capitole_consulting.challenge.domain.Price;

import java.time.LocalDateTime;

public interface GetPriceOfProductRepository {

    Price getFirstPriceWithHighestPriority(LocalDateTime applicationDate, Long productId, Long brandId);

}

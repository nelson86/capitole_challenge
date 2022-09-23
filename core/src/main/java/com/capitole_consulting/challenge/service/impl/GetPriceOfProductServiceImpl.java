package com.capitole_consulting.challenge.service.impl;

import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.exception.PriceNotFoundException;
import com.capitole_consulting.challenge.repository.GetPriceOfProductRepository;
import com.capitole_consulting.challenge.service.GetPriceOfProductService;
import com.capitole_consulting.challenge.shared.annotation.Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.Objects;

@Log4j2
@AllArgsConstructor
@Service
public class GetPriceOfProductServiceImpl implements GetPriceOfProductService {

    private GetPriceOfProductRepository getPriceOfProductRepository;

    @Override
    public Price getPriceOfProduct(LocalDateTime applicationDate, Long productId, Long brandId) {

        Price price = this.getPriceOfProductRepository.getFirstPriceWithHighestPriority(applicationDate, productId, brandId);

        if(Objects.isNull(price))
            throw new PriceNotFoundException(
                    String.format("Not Found Price for applicationDate: %s, productId: %s, brandId: %s",
                            applicationDate, productId, brandId
                            )
            );

        return price;
    }

}

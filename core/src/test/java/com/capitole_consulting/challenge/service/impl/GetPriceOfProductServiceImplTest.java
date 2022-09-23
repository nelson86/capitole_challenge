package com.capitole_consulting.challenge.service.impl;

import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.exception.PriceNotFoundException;
import com.capitole_consulting.challenge.repository.GetPriceOfProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Random;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPriceOfProductServiceImplTest {

    @Mock
    private GetPriceOfProductRepository getPriceOfProductRepository;

    private GetPriceOfProductServiceImpl getPriceOfProductServiceImpl;

    private LocalDateTime applicationDate = LocalDateTime.now();
    private Long productId = new Random().nextLong();
    private Long brandId = new Random().nextLong();

    @BeforeEach
    void setUp() {
        getPriceOfProductServiceImpl = new GetPriceOfProductServiceImpl(getPriceOfProductRepository);
        applicationDate = LocalDateTime.now();
        productId = new Random().nextLong();
        brandId = new Random().nextLong();
    }

    @Test
    void shouldReturnPrice() {
        Price priceMock = Mockito.mock(Price.class);
        when(getPriceOfProductRepository.getFirstPriceWithHighestPriority(applicationDate, productId, brandId)).thenReturn(priceMock);

        Price result = getPriceOfProductServiceImpl.getPriceOfProduct(applicationDate, productId, brandId);

        Assertions.assertEquals(priceMock, result);
    }

    @Test
    void shouldReturnPriceNotFoundException() {
        when(getPriceOfProductRepository.getFirstPriceWithHighestPriority(applicationDate, productId, brandId)).thenReturn(null);

        Assertions.assertThrows(PriceNotFoundException.class,
                () -> getPriceOfProductServiceImpl.getPriceOfProduct(applicationDate, productId, brandId)
        );
    }
}
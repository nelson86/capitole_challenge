package com.capitole_consulting.challenge.adapter;

import com.capitole_consulting.challenge.domain.Brand;
import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.entity.PriceEntity;
import com.capitole_consulting.challenge.repository.GetPriceOfProductRepository;
import com.capitole_consulting.challenge.repository.PriceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class GetPriceOfProductRepositoryImpl implements GetPriceOfProductRepository {

    @Autowired
    private PriceJpaRepository repository;

    @Override
    public Price getFirstPriceWithHighestPriority(LocalDateTime applicationDate, Long productId, Long brandId) {

        PriceEntity priceEntity = repository.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate
        ).orElse(null);

        if (Objects.isNull(priceEntity))
            return null;

        return mapToDomain(priceEntity);
    }

    private Price mapToDomain(PriceEntity priceEntity) {
        Brand brand = Brand.builder()
                .id(priceEntity.getBrand().getId())
                .name(priceEntity.getBrand().getName())
                .build();

        return Price.builder()
                .id(priceEntity.getId())
                .brand(brand)
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .priceList(priceEntity.getPriceList())
                .productId(priceEntity.getProductId())
                .priority(priceEntity.getPriority())
                .priceValue(priceEntity.getPrice())
                .curr(priceEntity.getCurr())
                .build();
    }

}

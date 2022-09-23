package com.capitole_consulting.challenge.adapter;

import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.entity.PriceEntity;
import com.capitole_consulting.challenge.mapper.PriceEntityMapper;
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

    @Autowired
    private PriceEntityMapper priceEntityMapper;

    @Override
    public Price getFirstPriceWithHighestPriority(LocalDateTime applicationDate, Long productId, Long brandId) {

        PriceEntity priceEntity = repository.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate
        ).orElse(null);

        if (Objects.isNull(priceEntity))
            return null;

        return priceEntityMapper.toDomain(priceEntity);
    }

}

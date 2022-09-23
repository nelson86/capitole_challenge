package com.capitole_consulting.challenge.mapper;

import com.capitole_consulting.challenge.domain.Price;
import com.capitole_consulting.challenge.entity.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PriceEntityMapper {

    @Mapping(source = "priceValue", target = "price")
    PriceEntity toEntity(Price price);

    @InheritInverseConfiguration
    Price toDomain(PriceEntity priceEntity);

}

package com.capitole_consulting.challenge.mapper;

import com.capitole_consulting.challenge.domain.Brand;
import com.capitole_consulting.challenge.entity.BrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BrandEntityMapper {

    BrandEntity toEntity(Brand brand);

    @InheritInverseConfiguration
    Brand toDomain(BrandEntity brandEntity);

}

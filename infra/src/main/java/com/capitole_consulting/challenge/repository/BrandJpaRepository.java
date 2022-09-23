package com.capitole_consulting.challenge.repository;

import com.capitole_consulting.challenge.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<BrandEntity, Long> {

}

package com.spring.jwt.Interfaces;

import com.spring.jwt.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    // You can add custom repository methods here
}
package com.fleetmanagement.driver_service.repository;

import com.fleetmanagement.common_entities.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Additional query methods can be defined here if needed
}

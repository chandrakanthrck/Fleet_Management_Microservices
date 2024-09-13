package com.fleetmanagement.driver_service.repository;

import com.fleetmanagement.driver_service.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Additional query methods can be defined here if needed
}

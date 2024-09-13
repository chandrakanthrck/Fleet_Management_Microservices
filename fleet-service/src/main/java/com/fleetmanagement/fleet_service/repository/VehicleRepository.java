package com.fleetmanagement.fleet_service.repository;

import com.fleetmanagement.fleet_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Additional query methods can be added here if needed
}

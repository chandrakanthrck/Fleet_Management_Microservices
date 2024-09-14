package com.fleetmanagement.fleet_service.repository;

import com.fleetmanagement.fleet_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {
    // Additional query methods can be added here if needed
}

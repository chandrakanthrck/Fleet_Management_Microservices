package com.fleetmanagement.driver_service.service;

import com.fleetmanagement.common_entities.entities.Driver;
import com.fleetmanagement.driver_service.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Create or update a driver
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Retrieve all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Retrieve a driver by ID
    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    // Delete a driver by ID
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}

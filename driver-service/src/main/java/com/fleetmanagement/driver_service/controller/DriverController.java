package com.fleetmanagement.driver_service.controller;

import com.fleetmanagement.driver_service.entity.Driver;
import com.fleetmanagement.driver_service.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Create or update a driver
    @PostMapping
    public ResponseEntity<Driver> saveDriver(@Valid @RequestBody Driver driver) {
        Driver savedDriver = driverService.saveDriver(driver);
        return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    }

    // Get all drivers
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    // Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable(name = "id") Long id) {
        Optional<Driver> driver = driverService.getDriverById(id);
        return driver.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete driver by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable(name = "id") Long id) {
        driverService.deleteDriver(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

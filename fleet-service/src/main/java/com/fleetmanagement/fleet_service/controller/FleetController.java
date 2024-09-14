package com.fleetmanagement.fleet_service.controller;

import com.fleetmanagement.fleet_service.entity.Vehicle;
import com.fleetmanagement.fleet_service.service.FleetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class FleetController {

    @Autowired
    private FleetService fleetService;

    // Create or update a vehicle
    @PostMapping
    public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = fleetService.saveVehicle(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    // Get all vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(
            @RequestParam(name = "make", required = false) String make,
            @RequestParam(name = "model", required = false) String model,
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "sortBy", required = false) String sortBy){
        List<Vehicle> vehicles = fleetService.getAllVehicles(make, model, year, sortBy);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable(name = "id") Long id) {
        Optional<Vehicle> vehicle = fleetService.getVehicleById(id);
        return vehicle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete vehicle by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable(name = "id") Long id) {
        fleetService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

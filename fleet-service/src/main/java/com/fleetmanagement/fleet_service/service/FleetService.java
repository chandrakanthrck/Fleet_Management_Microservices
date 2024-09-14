package com.fleetmanagement.fleet_service.service;

import com.fleetmanagement.common_entities.entities.Driver;
import com.fleetmanagement.driver_service_client.DriverServiceClient;
import com.fleetmanagement.fleet_service.entity.Vehicle;
import com.fleetmanagement.fleet_service.repository.VehicleRepository;
import com.fleetmanagement.fleet_service.specification.VehicleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FleetService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverServiceClient driverServiceClient;

    public Driver getDriverById(Long id) {
        return driverServiceClient.getDriverById(id);
    }

    // Create or update a vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Retrieve all vehicles with filtering and sorting
    public List<Vehicle> getAllVehicles(String make, String model, Integer year, String sortBy) {
        Specification<Vehicle> spec = Specification.where(null);

        // Apply filtering
        if (make != null) {
            spec = spec.and(VehicleSpecification.hasMake(make));
        }
        if (model != null) {
            spec = spec.and(VehicleSpecification.hasModel(model));
        }
        if (year != null) {
            spec = spec.and(VehicleSpecification.hasYear(year));
        }

        // Create sorting object
        Sort sort = Sort.by(sortBy == null ? "id" : sortBy);

        // Fetch and return filtered/sorted data
        return vehicleRepository.findAll(spec, sort);
    }

    // Retrieve a vehicle by ID
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    // Delete a vehicle by ID
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}

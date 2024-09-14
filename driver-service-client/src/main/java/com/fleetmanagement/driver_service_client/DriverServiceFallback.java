package com.fleetmanagement.driver_service_client;

import com.fleetmanagement.common_entities.entities.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverServiceFallback implements DriverServiceClient {

    @Override
    public Driver getDriverById(Long id) {
        // Return a meaningful fallback Driver object
        return new Driver(id, "Fallback Driver", "N/A", "0000000000", "fallback@example.com");
    }
}
package com.fleetmanagement.driver_service_client;

import com.fleetmanagement.common_entities.entities.Driver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "driver-service", url = "http://localhost:8081")
public interface DriverServiceClient {

    @GetMapping("/drivers/{id}")
    Driver getDriverById(@PathVariable("id") Long id);
}

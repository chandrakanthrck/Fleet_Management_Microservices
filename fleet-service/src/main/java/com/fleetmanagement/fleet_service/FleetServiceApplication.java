package com.fleetmanagement.fleet_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.fleetmanagement.driver_service_client")
public class FleetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetServiceApplication.class, args);
	}

}

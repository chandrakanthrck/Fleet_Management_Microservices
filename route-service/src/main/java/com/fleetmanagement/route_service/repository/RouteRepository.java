package com.fleetmanagement.route_service.repository;

import com.fleetmanagement.route_service.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
    // Additional query methods can be added here if needed
}
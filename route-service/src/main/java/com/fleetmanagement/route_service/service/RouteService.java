package com.fleetmanagement.route_service.service;

import com.fleetmanagement.route_service.entity.Route;
import com.fleetmanagement.route_service.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    // Create or update a route
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    // Retrieve all routes
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    // Retrieve a route by ID
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    // Delete a route by ID
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}

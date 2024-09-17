package com.fleetmanagement.tracking_service.service;

import com.fleetmanagement.tracking_service.entity.Tracking;
import com.fleetmanagement.tracking_service.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    @Autowired
    private OpenStreetMapService openStreetMapService;

    public Tracking updateLocation(String vehicleId, double latitude, double longitude) {
        // Call OpenStreetMap API to get the address
        String address = openStreetMapService.getAddressFromCoordinates(latitude, longitude);

        // Create tracking entry using Builder pattern
        Tracking tracking = Tracking.builder()
                .vehicleId(vehicleId)
                .latitude(latitude)
                .longitude(longitude)
                .timestamp(LocalDateTime.now())
                .build();

        // Optionally, store the address in the tracking entity if you have an address field
        // tracking.setAddress(address); // Uncomment if needed and add an address field in the Tracking entity

        return trackingRepository.save(tracking);
    }

    public List<Tracking> getVehicleHistory(String vehicleId) {
        return trackingRepository.findByVehicleId(vehicleId);
    }
}

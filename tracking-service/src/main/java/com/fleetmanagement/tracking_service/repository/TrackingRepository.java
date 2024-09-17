package com.fleetmanagement.tracking_service.repository;

import com.fleetmanagement.tracking_service.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findByVehicleId(String vehicleId);
}
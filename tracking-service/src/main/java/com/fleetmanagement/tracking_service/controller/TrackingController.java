package com.fleetmanagement.tracking_service.controller;

import com.fleetmanagement.tracking_service.entity.Tracking;
import com.fleetmanagement.tracking_service.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping("/update")
    public Tracking updateLocation(@RequestParam String vehicleId,
                                   @RequestParam double latitude,
                                   @RequestParam double longitude) {
        return trackingService.updateLocation(vehicleId, latitude, longitude);
    }

    @GetMapping("/history/{vehicleId}")
    public List<Tracking> getVehicleHistory(@PathVariable String vehicleId) {
        return trackingService.getVehicleHistory(vehicleId);
    }
}

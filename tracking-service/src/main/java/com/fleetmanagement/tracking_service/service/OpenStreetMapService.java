package com.fleetmanagement.tracking_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenStreetMapService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAddressFromCoordinates(double latitude, double longitude) {
        String url = String.format(
                "https://nominatim.openstreetmap.org/reverse?format=json&lat=%f&lon=%f",
                latitude, longitude
        );

        // Make API call
        String response = restTemplate.getForObject(url, String.class);

        // Process and return the response as needed
        return response;
    }
}

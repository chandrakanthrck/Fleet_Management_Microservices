package com.fleetmanagement.route_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Start location is mandatory")
    private String startLocation;
    @NotBlank(message = "End location is mandatory")
    private String endLocation;
    @NotNull(message = "Distance is mandatory")
    private double distance;
    @NotBlank(message = "Duration is mandatory")
    private String duration;
}

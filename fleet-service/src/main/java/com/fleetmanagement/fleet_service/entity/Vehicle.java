package com.fleetmanagement.fleet_service.entity;

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
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "License plate is mandatory")
    private String licensePlate;
    @NotBlank(message = "Make is mandatory")
    private String make;
    @NotBlank(message = "Model is mandatory")
    private String model;
    @NotNull(message = "Year is mandatory")
    private int year;
    @NotBlank(message = "Color is mandatory")
    private String color;
    private boolean available;
}

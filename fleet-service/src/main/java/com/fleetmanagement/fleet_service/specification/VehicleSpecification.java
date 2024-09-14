package com.fleetmanagement.fleet_service.specification;

import com.fleetmanagement.fleet_service.entity.Vehicle;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecification {

    public static Specification<Vehicle> hasMake(String make) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("make"), make);
    }

    public static Specification<Vehicle> hasModel(String model) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("model"), model);
    }

    public static Specification<Vehicle> hasYear(int year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("year"), year);
    }
}

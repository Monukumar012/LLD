package com.parkinglot.entity;

import com.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    private Long vehicleId;
    private VehicleType vehicleType;
    private String vehicleNumber;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
package com.rashi.vehicleserver.dto;

import com.rashi.vehicleserver.entity.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {
    private String vehicleId;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private boolean isHybrid;
    private double fuelUsage;
    private int seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driverName;
    private String driverNumber;
    private String driverLicense;
    private String rearView;
    private String frontView;
    private String sideView;
    private String otherSideView;

    public VehicleDTO(String vehicleBrand, String category, String fuelType, boolean isHybrid, double fuelUsage, int seatCapacity, String vehicleType, String transmission, String driverName, String driverNumber, String driverLicense, String rearView, String frontView, String sideView, String otherSideView) {
        this.vehicleBrand = vehicleBrand;
        this.category = category;
        this.fuelType = fuelType;
        this.isHybrid = isHybrid;
        this.fuelUsage = fuelUsage;
        this.seatCapacity = seatCapacity;
        this.vehicleType = vehicleType;
        this.transmission = transmission;
        this.driverName = driverName;
        this.driverNumber = driverNumber;
        this.driverLicense = driverLicense;
        this.rearView = rearView;
        this.frontView = frontView;
        this.sideView = sideView;
        this.otherSideView = otherSideView;
    }
}

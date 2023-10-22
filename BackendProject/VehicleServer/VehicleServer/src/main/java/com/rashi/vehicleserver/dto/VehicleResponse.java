package com.rashi.vehicleserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponse {
    private String vehicleId;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private boolean isHybrid;
    private double fuelUsage;
    private byte[]  frontView;
    private byte[]  rearView;
    private byte[]  sideView;
    private byte[]  otherSideView;
    private int seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driverName;
    private String driverNumber;
    private byte[]  driverLicense;

    public VehicleResponse(String vehicleId, String vehicleBrand, String category, String transmission, String fuelType, String driverName, String driverNumber) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.category = category;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.driverName = driverName;
        this.driverNumber = driverNumber;
    }
}

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
    private String frontView;
    private String rearView;
    private String sideView;
    private String otherSideView;
    private int seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driverName;
    private String driverNumber;
    private String driverLicense;



}
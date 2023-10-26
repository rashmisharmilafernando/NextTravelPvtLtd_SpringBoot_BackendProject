package com.rashi.vehicleserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponse {


    private String vehicleId;
    private String vehiclebrand;
    private String vehicleCategory;
    private String vehicleFueltype;
    private boolean hybrid_Status;
    private int vehicleFuelUsage;
    private int vehicleSeatCapacity;
    private String vehicleType;
    private String TransmissionType;
    private String vehicleDriverName;
    private String vehicleDriveNumber;
    private byte[] driverLicense;
    private byte[] rearView;
    private byte[] frontView;
    private byte[] sideView;
    private byte[] otherSideView;

    public VehicleResponse(String vehicleId, String vehiclebrand, String vehicleCategory, String vehicleFueltype, boolean hybrid_Status, int vehicleFuelUsage, int vehicleSeatCapacity, String vehicleType, String transmissionType, String vehicleDriverName, String vehicleDriveNumber) {
        this.vehicleId = vehicleId;
        this.vehiclebrand = vehiclebrand;
        this.vehicleCategory = vehicleCategory;
        this.vehicleFueltype = vehicleFueltype;
        this.hybrid_Status = hybrid_Status;
        this.vehicleFuelUsage = vehicleFuelUsage;
        this.vehicleSeatCapacity = vehicleSeatCapacity;
        this.vehicleType = vehicleType;
        this.TransmissionType = transmissionType;
        this.vehicleDriverName = vehicleDriverName;
        this.vehicleDriveNumber = vehicleDriveNumber;
    }
}

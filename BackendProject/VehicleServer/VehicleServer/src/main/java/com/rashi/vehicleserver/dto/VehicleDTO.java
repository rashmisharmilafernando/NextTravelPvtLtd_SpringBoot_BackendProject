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
    private String driverLicense;
    private String rearView;
    private String frontView;
    private String sideView;
    private String otherSideView;

}

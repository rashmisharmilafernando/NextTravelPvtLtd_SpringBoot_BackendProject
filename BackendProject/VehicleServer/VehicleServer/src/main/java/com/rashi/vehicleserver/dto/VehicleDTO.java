package com.rashi.vehicleserver.dto;

import com.rashi.vehicleserver.entity.VehicleEntity;
import com.rashi.vehicleserver.enums.HybridStatus;
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
    private String hybridStatus;
    private int vehicleFuelUsage;
    private int vehicleSeatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String vehicleDriverName;
    private String vehicleDriveNumber;
    private String driverLicense;
    private String rearView;
    private String frontView;
    private String sideView;
    private String otherSideView;

}

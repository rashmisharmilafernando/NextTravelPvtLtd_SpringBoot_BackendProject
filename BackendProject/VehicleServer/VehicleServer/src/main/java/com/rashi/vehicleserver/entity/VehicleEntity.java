package com.rashi.vehicleserver.entity;


import com.rashi.vehicleserver.enums.HybridStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleEntity implements SuperEntity{
    @Id
    private String vehicleId;
    private String vehicleRegId;
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
    @Column(columnDefinition = "LONGTEXT")
    private String driverLicense;
    @Column(columnDefinition = "LONGTEXT")
    private String rearView;
}

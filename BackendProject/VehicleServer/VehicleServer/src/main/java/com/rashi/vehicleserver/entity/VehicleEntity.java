package com.rashi.vehicleserver.entity;


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
    @Column(columnDefinition = "LONGTEXT")
    private String driverLicense;
    @Column(columnDefinition = "LONGTEXT")
    private String rearView;
    @Column(columnDefinition = "LONGTEXT")
    private String frontView;
    @Column(columnDefinition = "LONGTEXT")
    private String sideView;
    @Column(columnDefinition = "LONGTEXT")
    private String otherSideView;
}

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

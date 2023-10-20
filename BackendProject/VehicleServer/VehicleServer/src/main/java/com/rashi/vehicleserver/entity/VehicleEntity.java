package com.rashi.vehicleserver.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleEntity implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleId;
    @Column(nullable = false)
    private String vehicleBrand;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    private boolean isHybrid;
    @Column(nullable = false)
    private double fuelUsage;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String frontView;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String rearView;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String sideView;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String otherSideView;
    @Column(nullable = false)
    private int seatCapacity;
    @Column(nullable = false)
    private String vehicleType;
    @Column(nullable = false)
    private String transmission;
    @Column(nullable = false)
    private String driverName;
    @Column(nullable = false)
    private String driverNumber;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String driverLicense;
}

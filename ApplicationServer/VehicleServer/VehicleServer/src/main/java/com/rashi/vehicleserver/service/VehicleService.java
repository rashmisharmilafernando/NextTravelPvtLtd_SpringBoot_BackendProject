package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dto.CustomDTO;
import com.rashi.vehicleserver.dto.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String vehicleId);

    List<VehicleDTO> getAllVehicle();

   /* CustomDTO vehicleIdGenerate();*/


  /*  CustomDTO getAllVehicleCount();*/


    List<VehicleDTO> flterVehicleDetails(
            String category,
            int passengers,
            String transmission,
            String fuelType);


    String vehicleIdGenerate();

    int getAllVehicleCount();

    List<VehicleDTO> getAllVehicleByPackage(String vehicleCategory);

    VehicleDTO getAllVehicleByRegId(String registrationNumber);
}

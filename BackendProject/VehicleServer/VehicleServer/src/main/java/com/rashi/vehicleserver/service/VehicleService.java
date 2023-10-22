package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dto.CustomDTO;
import com.rashi.vehicleserver.dto.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String id);

    List<VehicleDTO> getAllVehicle();

    CustomDTO vehicleIdGenerate();

    VehicleDTO searchVehicleId(String vehicleId);

    CustomDTO getAllVehicleCount();

    ArrayList<VehicleDTO> flterVehicleDetails(String passengers, String transmission, String fuelType);


    /*void update(VehicleDTO vehicleDTO);*/
}

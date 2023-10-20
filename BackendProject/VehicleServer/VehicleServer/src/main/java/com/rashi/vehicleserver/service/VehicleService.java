package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dto.CustomDTO;
import com.rashi.vehicleserver.dto.VehicleDTO;
import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(String veicleId, VehicleDTO vehicleDTO);

    void deleteVehicle(String id);

    List<VehicleDTO> getAllVehicle();

    CustomDTO vehicleIdGenerate();

    VehicleDTO searchVehicleId(String vehicleId);

    CustomDTO getAllVehicleCount();


    /*void update(VehicleDTO vehicleDTO);*/
}

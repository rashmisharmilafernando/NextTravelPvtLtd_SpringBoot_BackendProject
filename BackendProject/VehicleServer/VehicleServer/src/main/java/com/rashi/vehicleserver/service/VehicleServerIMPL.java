package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dao.VehicleDAO;
import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.entity.VehicleEntity;
import com.rashi.vehicleserver.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleServerIMPL implements VehicleService{

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
      VehicleEntity vehicleEntity=dataTypeConversion.getVehicleEntity(vehicleDTO);
        vehicleDAO.save(vehicleEntity);
        return vehicleDTO;
    }

    @Override
    public void updateVehicle(String veicleId, VehicleDTO vehicleDTO) {
        vehicleDAO.save(dataTypeConversion.getVehicleEntity(vehicleDTO));
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleDAO.deleteById(id);
    }

    @Override
    public List<VehicleDTO>getAllVehicle() {
        return vehicleDAO.findAll().stream().map(vehicle->dataTypeConversion.getVehicleDTO(vehicle)).collect(Collectors.toList());
    }


}

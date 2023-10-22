package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dao.VehicleDAO;
import com.rashi.vehicleserver.dto.CustomDTO;
import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.entity.VehicleEntity;
import com.rashi.vehicleserver.util.DataConvertor;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleServerIMPL implements VehicleService{

    @Autowired
    private DataConvertor dataTypeConvertor;

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDAO.save(dataTypeConvertor.getVehicleEntity(vehicleDTO));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleDAO.existsById(vehicleDTO.getVehicleId())){
            throw new RuntimeException("Customer not Exist...!");
        }
        vehicleDAO.save(dataTypeConvertor.getVehicleEntity(vehicleDTO));
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleDAO.deleteById(id);
    }

    @Override
    public List<VehicleDTO>getAllVehicle() {
        return vehicleDAO.findAll().stream().map(vehicle->dataTypeConvertor.getVehicleDTO(vehicle)).collect(Collectors.toList());
    }

    @Override
    public CustomDTO vehicleIdGenerate() {
        return new CustomDTO(vehicleDAO.getLastIndex());
    }

    @Override
    public VehicleDTO searchVehicleId(String vehicleId) {
        if (!vehicleDAO.existsById(vehicleId)){
            throw new RuntimeException("Wrong ID...!");
        }
        VehicleEntity vehicleEntity = vehicleDAO.findById(vehicleId).get();
        return dataTypeConvertor.getVehicleDTO(vehicleEntity);

    }

    @Override
    public CustomDTO getAllVehicleCount() {
        return new CustomDTO(vehicleDAO.getAllVehicleCount());
    }

    @Override
    public ArrayList<VehicleDTO> flterVehicleDetails(String passengers, String transmission, String fuelType) {
        return (ArrayList<VehicleDTO>) vehicleDAO.filterVehicleDetails(passengers,transmission,fuelType).stream().map(vehicle ->dataTypeConvertor.getVehicleDTO(vehicle)).collect(Collectors.toList());
    }


}

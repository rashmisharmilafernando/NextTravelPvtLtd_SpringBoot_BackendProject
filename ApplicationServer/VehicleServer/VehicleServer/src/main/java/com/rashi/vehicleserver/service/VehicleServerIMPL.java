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
            throw new RuntimeException("Vehicle not Exist...!");
        }
        vehicleDAO.save(dataTypeConvertor.getVehicleEntity(vehicleDTO));
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        if (!vehicleDAO.existsById(vehicleId)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        vehicleDAO.deleteById(vehicleId);
    }

    @Override
    public ArrayList<VehicleDTO>getAllVehicle() {
        List<VehicleEntity> vehicleEntity=vehicleDAO.findAll();
        return dataTypeConvertor.vehicleDTOListTovehicleDTOList(vehicleEntity);
    }

    @Override
    public List<VehicleDTO> flterVehicleDetails(
            String category,
            int passengers,
            String transmission,
            String fuelType
    ) {
        return dataTypeConvertor.vehicleDTOListTovehicleDTOList(vehicleDAO.findAllByVehicleCategoryAndVehicleSeatCapacityAndTransmissionTypeAndVehicleFueltype(category,passengers,transmission,fuelType));

    }

    @Override
    public String vehicleIdGenerate() {
        return vehicleDAO.getLastIndex();
    }


    @Override
    public int getAllVehicleCount() {
        return  vehicleDAO.getAllVehicleCount();
    }

    @Override
    public List<VehicleDTO> getAllVehicleByPackage(String vehicleCategory) {
       if (!vehicleDAO.existsById(vehicleCategory))
           throw new RuntimeException(vehicleCategory+ "type vehicle not found...!");
       return dataTypeConvertor.vehicleDTOListTovehicleDTOList(vehicleDAO.findAllByVehicleCategory(vehicleCategory));
    }

    @Override
    public VehicleDTO getAllVehicleByRegId(String registrationNumber) {
        if (!vehicleDAO.existsById(registrationNumber))
            throw new RuntimeException(registrationNumber+" Car not found..!! ");
        return dataTypeConvertor.getVehicleDTO(vehicleDAO.findById(registrationNumber).get());
    }



}

package com.rashi.vehicleserver.service;

import com.rashi.vehicleserver.dao.VehicleDAO;
import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServerIMPL implements VehicleService{

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private VehicleDAO vehicleDAO;
    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        return dataTypeConversion.getVehicleDTO(vehicleDAO.save(dataTypeConversion.getVehicleEntity(vehicleDTO)));
    }
}

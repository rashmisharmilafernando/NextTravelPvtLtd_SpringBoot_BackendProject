package com.rashi.vehicleserver.util;


import com.rashi.vehicleserver.dto.VehicleDTO;
import com.rashi.vehicleserver.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    public DataTypeConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VehicleDTO getVehicleDTO(VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }

    public VehicleEntity getVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
}

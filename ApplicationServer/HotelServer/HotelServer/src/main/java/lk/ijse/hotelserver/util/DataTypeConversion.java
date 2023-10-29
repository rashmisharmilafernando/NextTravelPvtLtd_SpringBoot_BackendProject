package lk.ijse.hotelserver.util;

import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.entity.HotelEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataTypeConversion {
    private  final ModelMapper modelMapper;

    public DataTypeConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HotelEntity getHotelEntity(HotelDTO hotelDTO) {
            return modelMapper.map(hotelDTO,HotelEntity.class);
    }

    public HotelDTO getHotelDTO(HotelEntity hotelEntity) {
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    public ArrayList<HotelDTO> hotelDTOListToHotelDTOList(List<HotelEntity> hotelEntities) {
        return modelMapper.map(hotelEntities, new TypeToken<List<HotelDTO>>() {
        }.getType());

    }
}

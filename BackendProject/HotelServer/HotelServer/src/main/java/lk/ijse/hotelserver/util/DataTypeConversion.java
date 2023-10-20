package lk.ijse.hotelserver.util;

import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.entity.HotelEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {
    private ModelMapper modelMapper;

    public HotelEntity getHotelEntity(HotelDTO hotelDTO) {
            return modelMapper.map(hotelDTO,HotelEntity.class);
    }

    public HotelDTO getHotelDTO(HotelEntity hotelEntity) {
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }
}

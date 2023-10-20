package lk.ijse.hotelserver.service;

import lk.ijse.hotelserver.dto.HotelDTO;

import java.util.Arrays;
import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);

    void updateHotel(String hotelId, HotelDTO hotelDTO);

    void deleteHotel(String id);

    List<HotelDTO> getAllHotel();
}

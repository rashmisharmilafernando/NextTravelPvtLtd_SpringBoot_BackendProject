package lk.ijse.hotelserver.service;

import lk.ijse.hotelserver.dto.CustomDTO;
import lk.ijse.hotelserver.dto.HotelDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);

    void updateHotel(String hotelId, HotelDTO hotelDTO);

    void deleteHotel(String id);

    List<HotelDTO> getAllHotel();

    CustomDTO hotelIdGenerate();

    HotelDTO searchHotelId(String hotelId);

    CustomDTO getAllHotelCount();

    ArrayList<HotelDTO> filterHotelDetails(String startRate, String location);
}

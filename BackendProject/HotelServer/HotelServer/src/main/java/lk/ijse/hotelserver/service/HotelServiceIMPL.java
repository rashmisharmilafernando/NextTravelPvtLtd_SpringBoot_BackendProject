package lk.ijse.hotelserver.service;

import jakarta.transaction.Transactional;
import lk.ijse.hotelserver.dao.HotelDAO;
import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.entity.HotelEntity;
import lk.ijse.hotelserver.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelServiceIMPL implements HotelService{

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private HotelDAO hotelDAO;


    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        HotelEntity hotelEntity=dataTypeConversion.getHotelEntity(hotelDTO);
            hotelDAO.save(hotelEntity);
            return hotelDTO;
    }

    @Override
    public void updateHotel(String hotelId, HotelDTO hotelDTO) {
       hotelDAO.save(dataTypeConversion.getHotelEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(String id) {
        hotelDAO.deleteById(id);
    }

    @Override
    public List<HotelDTO> getAllHotel() {
        return hotelDAO.findAll().stream().map(hotel -> dataTypeConversion.getHotelDTO(hotel)).collect(Collectors.toList());
    }
}

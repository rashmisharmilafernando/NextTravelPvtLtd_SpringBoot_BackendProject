package lk.ijse.hotelserver.service;

import jakarta.transaction.Transactional;
import lk.ijse.hotelserver.dao.HotelDAO;
import lk.ijse.hotelserver.dto.CustomDTO;
import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.entity.HotelEntity;
import lk.ijse.hotelserver.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (!hotelDAO.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        hotelDAO.deleteById(id);
    }

    @Override
    public ArrayList<HotelDTO> getAllHotel() {
        List<HotelEntity> hotelEntities=hotelDAO.findAll();
        return dataTypeConversion.hotelDTOListToHotelDTOList(hotelEntities);
    }

    @Override
    public CustomDTO hotelIdGenerate() {
        return new CustomDTO(hotelDAO.getLastIndex());
    }

    @Override
    public HotelDTO searchHotelId(String hotelId) {
       if (!hotelDAO.existsById(hotelId)){
           throw new RuntimeException("Wrong ID...!");
       }
       HotelEntity hotelEntity=hotelDAO.findById(hotelId).get();
       return dataTypeConversion.getHotelDTO(hotelEntity);
    }

    @Override
    public CustomDTO getAllHotelCount() {
        return new CustomDTO(hotelDAO.getAllHotelCount());
    }

    @Override
    public List<HotelDTO> getAllHotelByStarRateAndLocation(String startRate, String location) {
        if (!hotelDAO.existsByStarRate(startRate))
            throw new RuntimeException(startRate+" Start Rate Category not exists");
        if (!hotelDAO.existsByLocation(location))
            throw new RuntimeException(startRate+" Location not exists");
        return dataTypeConversion.hotelDTOListToHotelDTOList(hotelDAO.findAllByStarRateAndHotelLocation(startRate,location));
    }

    @Override
    public List<HotelDTO> getAllHotelByPackage(String packageCategory) {
            if (!hotelDAO.existByPackage(packageCategory))
                throw new RuntimeException(packageCategory+ "Package not exists");
            return dataTypeConversion.hotelDTOListToHotelDTOList(hotelDAO.findAllByPackage(packageCategory));
    }

}

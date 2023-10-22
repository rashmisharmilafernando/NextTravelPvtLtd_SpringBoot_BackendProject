package lk.ijse.hotelserver.dao;

import lk.ijse.hotelserver.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HotelDAO extends JpaRepository<HotelEntity,String> {
    @Query(value = "SELECT hotelId FROM HotelEntity ORDER BY hotelId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();
    @Query(value = "SELECT COUNT(hotelId) FROM HotelEntity",nativeQuery = true)
    int getAllHotelCount();

    ArrayList<HotelEntity> filterHotelDetails(String startRate, String location);
}

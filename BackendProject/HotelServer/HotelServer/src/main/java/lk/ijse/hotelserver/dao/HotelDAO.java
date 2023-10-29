package lk.ijse.hotelserver.dao;

import lk.ijse.hotelserver.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HotelDAO extends JpaRepository<HotelEntity,String> {
    @Query(value = "SELECT hotelId FROM Hotel ORDER BY hotelId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();
    @Query(value = "SELECT COUNT(hotelId) FROM Hotel",nativeQuery = true)
    int getAllHotelCount();


    boolean existsByStarRate(String startRate);

    boolean existsByLocation(String location);

    List<HotelEntity> findAllByStarRateAndHotelLocation(String startRate, String location);
}

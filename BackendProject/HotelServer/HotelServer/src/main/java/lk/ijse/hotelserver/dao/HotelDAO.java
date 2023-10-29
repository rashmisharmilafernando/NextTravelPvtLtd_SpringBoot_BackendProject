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

    @Query(value = "SELECT 1 FROM Hotel where hotelRate=?1",nativeQuery = true)
    boolean existsByStarRate(String startRate);
    @Query(value = "SELECT 1 FROM Hotel where hotelLocation=?1",nativeQuery = true)
    boolean existsByLocation(String location);

    @Query(value = "SELECT * FROM Hotel WHERE hotelRate=?1 and hotelLocation=?2" , nativeQuery = true)
    List<HotelEntity> findAllByStarRateAndHotelLocation(String startRate, String location);
    @Query(value = "SELECT 1 FROM Hotel where  hotelCategory=?1",nativeQuery = true)
    boolean existByPackage(String packageCategory);

    @Query(value = "SELECT * FROM Hotel WHERE hotelCategory=?1" , nativeQuery = true)
    List<HotelEntity> findAllByPackage(String packageCategory);

}

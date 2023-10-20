package lk.ijse.hotelserver.dao;

import lk.ijse.hotelserver.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO extends JpaRepository<HotelEntity,String> {

}

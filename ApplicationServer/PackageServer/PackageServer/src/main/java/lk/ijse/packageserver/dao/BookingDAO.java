package lk.ijse.packageserver.dao;

import lk.ijse.packageserver.enetity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<BookingEntity,String> {
    @Query(value = "SELECT bookingId FROM booking ORDER BY bookingId DESC LIMIT 1", nativeQuery = true)
    int getLastIndex();
    @Query(value = "SELECT COUNT(bookingId) FROM booking", nativeQuery = true)
    String getAllBookingCount();

   BookingEntity findBookingByUserId(String userId);


    List<BookingEntity> findBookingsByUserId(String userId);
}

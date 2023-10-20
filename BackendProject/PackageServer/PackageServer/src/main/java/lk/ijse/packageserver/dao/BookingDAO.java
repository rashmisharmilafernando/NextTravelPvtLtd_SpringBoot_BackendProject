package lk.ijse.packageserver.dao;

import lk.ijse.packageserver.enetity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDAO extends JpaRepository<BookingEntity,String> {

}

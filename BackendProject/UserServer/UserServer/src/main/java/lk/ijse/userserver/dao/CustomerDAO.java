package lk.ijse.userserver.dao;

import lk.ijse.userserver.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
   @Query(value = "SELECT ID from CustomerEntity order by ID desc LIMIT 1",nativeQuery = true)
    String getLastIndex();
}

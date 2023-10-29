package lk.ijse.userserver.dao;

import lk.ijse.userserver.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<AdminEntity,String> {

}

package lk.ijse.userserver.dao;


import lk.ijse.userserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT * from UserEntity WHERE username=? and password=?",nativeQuery = true)
    UserEntity findUserByUser_NameAndPassword(String username, String password) throws RuntimeException;
}

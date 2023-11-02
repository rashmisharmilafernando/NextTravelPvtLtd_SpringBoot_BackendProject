package lk.ijse.userserver.dao;


import lk.ijse.userserver.entity.UserEntity;
import lk.ijse.userserver.util.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.function.Supplier;

public interface UserDAO extends JpaRepository<UserEntity,String> {

    boolean existsByEmail(String email);

    void deleteByEmail(String userEmail);

    @Query(value = "SELECT userId FROM User ORDER BY userId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

    int countByRoleType(RoleType roleType);

    Optional<UserEntity> findByEmail(String email);
}

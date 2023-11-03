package lk.ijse.userserver.service;

import com.rashi.userserver.dto.CustomDTO;
import lk.ijse.userserver.dto.UsersDTO;
import lk.ijse.userserver.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface Userservice {

    void saveUser(UsersDTO usersDTO);

    void updateUser(UsersDTO usersDTO);

    void deleteUser(String userEmail);

    List<UsersDTO> getAllUsers();

    CustomDTO getLastIndex();

    int countByRoleType(RoleType roleType);

    UsersDTO userFindByEmail(String userEmail);
}

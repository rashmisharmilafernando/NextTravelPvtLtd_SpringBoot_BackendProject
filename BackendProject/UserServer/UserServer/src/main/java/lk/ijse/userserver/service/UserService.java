package lk.ijse.userserver.service;

import lk.ijse.userserver.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String id);

    List<UserDTO> getAllUser();
}

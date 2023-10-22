package lk.ijse.userserver.service;

import lk.ijse.userserver.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveUser(AdminDTO userDTO);

    void updateUser(AdminDTO userDTO);

    void deleteUser(String id);

    List<AdminDTO> getAllUser();


}

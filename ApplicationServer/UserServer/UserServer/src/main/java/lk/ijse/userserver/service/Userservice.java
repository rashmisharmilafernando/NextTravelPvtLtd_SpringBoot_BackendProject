package lk.ijse.userserver.service;

import lk.ijse.userserver.dto.UsersDTO;

import java.util.ArrayList;

public interface Userservice {
    ArrayList<UsersDTO> getAllUsers();

    UsersDTO getUsernamePassword(String username, String password);
}

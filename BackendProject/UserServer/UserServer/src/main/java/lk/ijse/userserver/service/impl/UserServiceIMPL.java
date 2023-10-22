package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dao.UserDAO;
import lk.ijse.userserver.dto.UserDTO;
import lk.ijse.userserver.service.UserService;
import lk.ijse.userserver.util.DataConvertor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceIMPL implements UserService {

    private final DataConvertor dataConvertor;

    private final UserDAO userDAO;

    public UserServiceIMPL(DataConvertor dataConvertor, UserDAO userDAO) {
        this.dataConvertor = dataConvertor;
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userDAO.save(dataConvertor.userdtoTOuserEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (!userDAO.existsById(userDTO.getUserID())){
            throw new RuntimeException("User not exist...!");
        }
        userDAO.save(dataConvertor.userdtoTOuserEntity(userDTO));
    }

    @Override
    public void deleteUser(String id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userDAO.findAll().stream().map(userEntity -> dataConvertor.userEntityTOuserDto(userEntity)).collect(Collectors.toList());
    }
}

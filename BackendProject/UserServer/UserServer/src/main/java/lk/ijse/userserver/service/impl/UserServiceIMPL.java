package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dao.UserDAO;
import lk.ijse.userserver.dto.UsersDTO;
import lk.ijse.userserver.service.Userservice;
import lk.ijse.userserver.util.DataConvertor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class UserServiceIMPL implements Userservice {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private  DataConvertor dataConvertor;
    @Override
    public ArrayList<UsersDTO> getAllUsers() {
        return (ArrayList<UsersDTO>) dataConvertor.userDtoListToserEntityList(userDAO.findAll(), new TypeToken<ArrayList<UsersDTO>>() {
        }.getType());

    }

    @Override
    public UsersDTO getUsernamePassword(String username, String password) {
        return dataConvertor.userEntityTOUserDto(userDAO.findUserByUser_NameAndPassword(username,password));
    }
}

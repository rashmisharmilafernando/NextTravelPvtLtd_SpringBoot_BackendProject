package lk.ijse.userserver.service.impl;

import com.rashi.userserver.dto.CustomDTO;
import lk.ijse.userserver.dao.UserDAO;
import lk.ijse.userserver.dto.UsersDTO;
import lk.ijse.userserver.entity.UserEntity;
import lk.ijse.userserver.service.Userservice;
import lk.ijse.userserver.util.DataConvertor;
import lk.ijse.userserver.util.RoleType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceIMPL implements Userservice {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    DataConvertor dataConvertor;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void saveUser(UsersDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDAO.save(dataConvertor.userDtoTOUserEntity(userDTO));
    }

    @Override
    public void updateUser(UsersDTO usersDTO) {
        if (!userDAO.existsById(usersDTO.getUserId()))
            throw new RuntimeException(usersDTO.getUserId()+" User Not in the system..!! ");
        if (!userDAO.existsByEmail(usersDTO.getEmail()))
            throw new RuntimeException(usersDTO.getEmail()+" User Not in the system..!! ");
        userDAO.save(dataConvertor.userDtoTOUserEntity(usersDTO));
    }

    @Override
    public void deleteUser(String userEmail) {
        if (!userDAO.existsByEmail(userEmail))
            throw new RuntimeException(userEmail+" User Not in the system..!! ");
        userDAO.deleteByEmail(userEmail);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return dataConvertor.userEntityListToUserDTOList(userDAO.findAll());
    }

    @Override
    public CustomDTO getLastIndex() {
        return new  CustomDTO (userDAO.getLastIndex());
    }

    @Override
    public int countByRoleType(RoleType roleType) {
        return userDAO.countByRoleType(roleType);
    }

    @Override
    public UsersDTO userFindByEmail(String email) {
        if (!userDAO.existsByEmail(email))
            throw new RuntimeException(email+" User Not in the system..!! ");
        return dataConvertor.userEntityToUserDto((UserEntity) userDAO.findByEmail(email).get());

    }
}

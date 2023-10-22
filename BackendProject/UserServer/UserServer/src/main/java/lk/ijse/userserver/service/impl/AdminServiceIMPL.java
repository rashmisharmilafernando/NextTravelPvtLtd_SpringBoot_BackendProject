package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dao.AdminDAO;
import lk.ijse.userserver.dto.AdminDTO;
import lk.ijse.userserver.service.AdminService;
import lk.ijse.userserver.util.DataConvertor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceIMPL implements AdminService {

    private final DataConvertor dataConvertor;

    private final AdminDAO userDAO;

    public AdminServiceIMPL(DataConvertor dataConvertor, AdminDAO userDAO) {
        this.dataConvertor = dataConvertor;
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(AdminDTO userDTO) {
        userDAO.save(dataConvertor.admindtoTOAdminEntity(userDTO));
    }

    @Override
    public void updateUser(AdminDTO userDTO) {
        if (!userDAO.existsById(userDTO.getUserID())){
            throw new RuntimeException("User not exist...!");
        }
        userDAO.save(dataConvertor.admindtoTOAdminEntity(userDTO));
    }

    @Override
    public void deleteUser(String id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<AdminDTO> getAllUser() {
        return userDAO.findAll().stream().map(userEntity -> dataConvertor.adminEntityTOAdminDto(userEntity)).collect(Collectors.toList());
    }

}

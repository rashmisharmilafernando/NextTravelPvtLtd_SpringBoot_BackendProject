package lk.ijse.userserver.util;

import lk.ijse.userserver.dto.CustomerDTO;
import lk.ijse.userserver.dto.AdminDTO;
import lk.ijse.userserver.dto.UsersDTO;
import lk.ijse.userserver.entity.CustomerEntity;
import lk.ijse.userserver.entity.AdminEntity;
import lk.ijse.userserver.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class DataConvertor {

    private final ModelMapper modelMapper;


    public DataConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AdminEntity admindtoTOAdminEntity(AdminDTO adminDTO) {
        return modelMapper.map(adminDTO, AdminEntity.class);
    }

    public AdminDTO adminEntityTOAdminDto(AdminEntity adminEntity){
        return modelMapper.map(adminEntity, AdminDTO.class);
    }


    public CustomerEntity customerdtoTOcustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO customerEntityTOcustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }


    public UserEntity userDtoTOUserEntity(UsersDTO usersDTO) {
        return modelMapper.map(usersDTO, UserEntity.class);
    }

    public UsersDTO userEntityTOUserDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UsersDTO.class);
    }

    public List<UsersDTO> userDtoListToserEntityList(List<UserEntity> vehicleEntityList, Type type) {
        return modelMapper.map(vehicleEntityList, new TypeToken<List<UsersDTO>>() {
        }.getType());
    }



}

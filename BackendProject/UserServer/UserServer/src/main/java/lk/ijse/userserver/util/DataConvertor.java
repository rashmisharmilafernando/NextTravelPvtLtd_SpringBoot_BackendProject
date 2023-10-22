package lk.ijse.userserver.util;

import lk.ijse.userserver.dto.CustomerDTO;
import lk.ijse.userserver.dto.UserDTO;
import lk.ijse.userserver.entity.CustomerEntity;
import lk.ijse.userserver.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataConvertor {

    private final ModelMapper modelMapper;


    public DataConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserEntity userdtoTOuserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO userEntityTOuserDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    // Converts a PackageDTO to a PackageEntity
    public CustomerEntity customerdtoTOcustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO customerEntityTOcustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
}

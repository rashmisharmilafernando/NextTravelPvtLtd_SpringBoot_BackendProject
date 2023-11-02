package lk.ijse.userserver.util;

import lk.ijse.userserver.dto.UsersDTO;
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

    public UserEntity userDtoTOUserEntity(UsersDTO usersDTO) {
        return modelMapper.map(usersDTO, UserEntity.class);
    }


    public List<UsersDTO> userEntityListToUserDTOList(List<UserEntity> users){
        return modelMapper.map(users,new TypeToken<List<UsersDTO>>(){}.getType());
    }

    public UsersDTO userEntityToUserDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UsersDTO.class);
    }
}

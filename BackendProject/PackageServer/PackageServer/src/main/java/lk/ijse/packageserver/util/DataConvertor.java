package lk.ijse.packageserver.util;

import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.PackageEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConvertor {

    private final ModelMapper modelMapper;

    public DataConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public PackageEntity getPackageEntity(PackageDTO packageDTO) {
         return modelMapper.map(packageDTO, PackageEntity.class);
    }

    public Object getPackageDTO(PackageEntity packageEntity) {
        return modelMapper.map(packageEntity, PackageDTO.class);
    }

    public List<PackageDTO> pacackageDTOtoPackageDTOList(List<PackageDTO> packageEntityList){
        return modelMapper.map(packageEntityList,new TypeToken<List<PackageDTO>>(){
        }.getType());
    }
}

package lk.ijse.guideserver.util;

import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataConvertor {
    private final ModelMapper modelMapper;

    public DataConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GuideEntity getGuideEntity(GuideDTO guideDTO) {
        return modelMapper.map(guideDTO, GuideEntity.class);
    }

    public GuideDTO getGuideDTO(GuideEntity guideEntity) {
        return modelMapper.map(guideEntity, GuideDTO.class);
    }

}

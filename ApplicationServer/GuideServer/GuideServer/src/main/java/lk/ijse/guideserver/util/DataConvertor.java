package lk.ijse.guideserver.util;

import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<GuideDTO> guideDTOListToGuideEntityList(List<GuideEntity> guideEntities) {
        return modelMapper.map(guideEntities, new TypeToken<List<GuideDTO>>() {
        }.getType());
    }
}

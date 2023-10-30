package lk.ijse.guideserver.server;

import lk.ijse.guideserver.dao.GuideDAO;
import lk.ijse.guideserver.dto.CustomDTO;
import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import lk.ijse.guideserver.util.DataConvertor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GuideServiceIMPL implements GuideService{

   @Autowired
   private DataConvertor dataConvertor;
   @Autowired
   private GuideDAO guideDAO;

    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO) {
        GuideEntity guideEntity=dataConvertor.getGuideEntity(guideDTO);
        guideDAO.save(guideEntity);
        return guideDTO;
    }

    @Override
    public void updateGuide(GuideDTO guideDTO) {
        if (!guideDAO.existsById(guideDTO.getGuideId())){
            throw new RuntimeException("Guide not Exist...!");
        }
        guideDAO.save(dataConvertor.getGuideEntity(guideDTO));
    }

    @Override
    public void deleteGuide(String id) {
        if (!guideDAO.existsById(id)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        guideDAO.deleteById(id);
    }

    @Override
    public ArrayList<GuideDTO> getAllGuide() {
        List<GuideEntity> guideEntities= (List<GuideEntity>) guideDAO.findAll();
       return dataConvertor.guideDTOListToGuideEntityList(guideEntities);
    }

    @Override
    public CustomDTO guideIdGenerate() {
        return new CustomDTO(guideDAO.getLastIndex());
    }

    @Override
    public CustomDTO getAllGuideCount() {
        return new CustomDTO((int) guideDAO.count());
    }


}

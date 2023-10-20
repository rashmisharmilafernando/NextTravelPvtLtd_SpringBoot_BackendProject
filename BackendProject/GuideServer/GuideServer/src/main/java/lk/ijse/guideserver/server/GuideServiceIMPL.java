package lk.ijse.guideserver.server;

import lk.ijse.guideserver.dao.GuideDAO;
import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.entity.GuideEntity;
import lk.ijse.guideserver.util.DataConvertor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void updateGuide(String id, GuideDTO guideDTO) {
        guideDAO.save(dataConvertor.getGuideEntity(guideDTO));
    }

    @Override
    public void deleteGuide(String id) {
        guideDAO.deleteById(id);
    }

    @Override
    public List<GuideDTO> getAllGuide() {
        return guideDAO.findAll().stream().map(guideEntity -> dataConvertor.getGuideDTO(guideEntity)).collect(Collectors.toList());
    }
}

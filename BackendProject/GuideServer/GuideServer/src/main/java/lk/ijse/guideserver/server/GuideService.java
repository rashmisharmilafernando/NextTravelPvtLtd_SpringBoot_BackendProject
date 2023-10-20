package lk.ijse.guideserver.server;

import lk.ijse.guideserver.dto.GuideDTO;

import java.util.Arrays;
import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);

    void updateGuide(String id, GuideDTO guideDTO);

    void deleteGuide(String id);


    List<GuideDTO> getAllGuide();
}

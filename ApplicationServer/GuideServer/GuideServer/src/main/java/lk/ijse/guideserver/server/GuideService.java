package lk.ijse.guideserver.server;

import lk.ijse.guideserver.dto.CustomDTO;
import lk.ijse.guideserver.dto.GuideDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);

    void updateGuide(GuideDTO guideDTO);

    void deleteGuide(String id);


    ArrayList<GuideDTO> getAllGuide();


    CustomDTO guideIdGenerate();

    CustomDTO getAllGuideCount();
}

package lk.ijse.guideserver.controller;


import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.dto.GuideResponse;
import lk.ijse.guideserver.server.GuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guide")
@CrossOrigin("*")
public class GuideController {

    private final GuideService guideServer;

    public GuideController(GuideService guideServer) {
        this.guideServer = guideServer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GuideDTO saveGuide(
            @RequestParam String guideId,
            @RequestParam String guideName,
            @RequestParam String address,
            @RequestParam String gender,
            @RequestParam String number,
            @RequestParam String experience,
            @RequestParam double manDayValue,
            @RequestParam String guideImage,
            @RequestParam String nicImage,
            @RequestParam String guideIDImage
    ) {
        if (guideImage.isEmpty() && nicImage.isEmpty() && guideIDImage.isEmpty()) {
            throw new RuntimeException("Empty...!");
        }
        try {
            String guide_Image = Base64.getEncoder().encodeToString(guideImage.getBytes());
            String nic_image = Base64.getEncoder().encodeToString(nicImage.getBytes());
            String guideId_Image = Base64.getEncoder().encodeToString(guideIDImage.getBytes());

            GuideDTO guideDTO = new GuideDTO(
                    guideId,
                    guideName,
                    address,
                    gender,
                    number,
                    experience,
                    manDayValue,
                    guide_Image,
                    nic_image,
                    guideId_Image
            );
            return guideServer.saveGuide(guideDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//--------------------------UPDATE----------------------------------
    @PutMapping
    public void updateGuide(@PathVariable String id,@RequestBody GuideDTO guideDTO){
        guideServer.updateGuide(id,guideDTO);
    }
//------------------------------DELETE------------------------------------

    @DeleteMapping
    public void deleteGuide(String id){
        guideServer.deleteGuide(id);
    }
//----------------------------GET--ALL--GUIDE---------------------

    @GetMapping
    public ResponseEntity<List<GuideResponse>> getAllGuide(){
        List<GuideResponse>guideResponses=guideServer.getAllGuide().stream().map(e ->
                new GuideResponse(



                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(guideResponses,HttpStatus.OK);
    }








}

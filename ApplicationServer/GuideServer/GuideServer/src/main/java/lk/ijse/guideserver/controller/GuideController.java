package lk.ijse.guideserver.controller;

import lk.ijse.guideserver.dto.CustomDTO;
import lk.ijse.guideserver.dto.GuideDTO;
import lk.ijse.guideserver.server.GuideService;
import lk.ijse.guideserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin("*")
public class GuideController {

    private final GuideService guideServer;

    public GuideController(GuideService guideServer) {
        this.guideServer = guideServer;
    }
//------------------save-----------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveGuide(
            @RequestParam(value = "guide_id") String guide_id,
            @RequestParam(value = "guide_Name") String guide_Name,
            @RequestParam(value = "guide_Address") String guide_Address,
            @RequestParam(value = "guide_Gender") String guide_Gender,
            @RequestParam(value = "guide_Number") String guide_Number,
            @RequestParam(value = "guide_Experience") String guide_Experience,
            @RequestParam(value = "guide_Day_Value") double guide_Day_Value,
            @RequestParam(value = "Guide_Image") String Guide_Image,
            @RequestParam(value = "Nic_Image") String Nic_Image,
            @RequestParam(value = "Guide_ID_Image") String Guide_ID_Image
    ) {
        if (Guide_Image.isEmpty() && Nic_Image.isEmpty() && Guide_ID_Image.isEmpty()) {
            throw new RuntimeException("Empty...!");
        }
        try {
            guideServer.saveGuide(new GuideDTO(
                    guide_id,
                    guide_Name,
                    guide_Address,
                    guide_Gender,
                    guide_Number,
                    guide_Experience,
                    guide_Day_Value,
                    Base64.getEncoder().encodeToString(Guide_Image.getBytes()),
                    Base64.getEncoder().encodeToString(Nic_Image.getBytes()),
                    Base64.getEncoder().encodeToString(Guide_ID_Image.getBytes())));
            return ResponseEntity.ok("Guide created successfully..!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------------UPDATE----------------------------------
    @PutMapping("/update")
    public ResponseUtil updateGuide(
            @RequestParam(value = "guide_id") String guide_id,
            @RequestParam(value = "guide_Name") String guide_Name,
            @RequestParam(value = "guide_Address") String guide_Address,
            @RequestParam(value = "guide_Gender") String guide_Gender,
            @RequestParam(value = "guide_Number") String guide_Number,
            @RequestParam(value = "guide_Experience") String guide_Experience,
            @RequestParam(value = "guide_Day_Value") double guide_Day_Value,
            @RequestParam(value = "Guide_Image") String Guide_Image,
            @RequestParam(value = "Nic_Image") String Nic_Image,
            @RequestParam(value = "Guide_ID_Image") String Guide_ID_Image)
    {
        if (Guide_Image.isEmpty() && Nic_Image.isEmpty() && Guide_ID_Image.isEmpty()) {
            throw new RuntimeException("Empty...!");
        }
        try {
            guideServer.updateGuide(new GuideDTO(
                    guide_id,
                    guide_Name,
                    guide_Address,
                    guide_Gender,
                    guide_Number,
                    guide_Experience,
                    guide_Day_Value,
                    Base64.getEncoder().encodeToString(Guide_Image.getBytes()),
                    Base64.getEncoder().encodeToString(Nic_Image.getBytes()),
                    Base64.getEncoder().encodeToString(Guide_ID_Image.getBytes())));

            return new ResponseUtil("OK", "Update is Successfully...!", null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//------------------------------DELETE------------------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseEntity<String> deleteGuide(@RequestParam String id) {
        guideServer.deleteGuide(id);
        return ResponseEntity.ok("Guide deleted Successfully...!");
    }

    //----------------------------GET--ALL--GUIDE---------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllGuide")
    public ResponseUtil getAllCar() {
        return new ResponseUtil("Ok", "Successfully", guideServer.getAllGuide());
    }


    //------- Auto Generate id--------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/autoGenerateid")
    public @ResponseBody CustomDTO guideIdGenerate() {
        System.out.println("autoGenerateId");
        return guideServer.guideIdGenerate();
    }
    //-------Vehicle-Count------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/guideCount")
    public @ResponseBody CustomDTO getSumGuide() {
        return guideServer.getAllGuideCount();
    }



}

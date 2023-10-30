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
@RequestMapping("/guide")
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
            guideServer.saveGuide(new GuideDTO(
                    guideId,
                    guideName,
                    address,
                    gender,
                    number,
                    experience,
                    manDayValue,
                    Base64.getEncoder().encodeToString(guideImage.getBytes()),
                    Base64.getEncoder().encodeToString(nicImage.getBytes()),
                    Base64.getEncoder().encodeToString(guideIDImage.getBytes())));

            return ResponseEntity.ok("Guide created successfully..!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------------UPDATE----------------------------------
    @PutMapping("/update")
    public ResponseUtil updateGuide(
            @RequestParam String guideId,
            @RequestParam String guideName,
            @RequestParam String address,
            @RequestParam String gender,
            @RequestParam String number,
            @RequestParam String experience,
            @RequestParam double manDayValue,
            @RequestParam String guideImage,
            @RequestParam String nicImage,
            @RequestParam String guideIDImage) {
        if (guideImage.isEmpty() && nicImage.isEmpty() && guideIDImage.isEmpty()) {
            throw new RuntimeException("Empty...!");
        }
        try {
            guideServer.updateGuide(new GuideDTO(
                    guideId,
                    guideName,
                    address,
                    gender,
                    number,
                    experience,
                    manDayValue,
                    Base64.getEncoder().encodeToString(guideImage.getBytes()),
                    Base64.getEncoder().encodeToString(nicImage.getBytes()),
                    Base64.getEncoder().encodeToString(guideIDImage.getBytes())));

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
    @GetMapping(path = "/autoGenerateId")
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

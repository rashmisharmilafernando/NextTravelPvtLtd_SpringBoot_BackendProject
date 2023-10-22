package lk.ijse.hotelserver.controller;


import lk.ijse.hotelserver.dto.CustomDTO;
import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.dto.HotelRespone;
import lk.ijse.hotelserver.service.HotelService;
import lk.ijse.hotelserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //------------------save hotel---------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveHotel(

            @RequestParam String hotelId,
            @RequestParam String hotelLocation,
            @RequestParam String hotelName,
            @RequestParam String coordinates,
            @RequestParam String roomType,
            @RequestParam String starRate,
            @RequestParam String packageCategory,
            @RequestParam String hotelContactNumber,
            @RequestParam boolean petsAllowedOrNot,
            @RequestParam String cancelCriteria,
            @RequestParam String remarks,
            @RequestParam double hotelFee,
            @RequestParam String email,
            @RequestParam MultipartFile hotelImage
    ) {
        if (hotelImage.isEmpty()) {
            throw new RuntimeException("This Hotel Image is Empty...!");
        }
        try {
            String hotel_Image = Base64.getEncoder().encodeToString(hotelImage.getBytes());

            HotelDTO hotelDTO = new HotelDTO(

                    hotelId,
                    hotelLocation,
                    hotelName,
                    coordinates,
                    roomType,
                    starRate,
                    packageCategory,
                    hotelContactNumber,
                    petsAllowedOrNot,
                    cancelCriteria,
                    remarks,
                    hotelFee,
                    email,
                    hotel_Image
            );
            return new ResponseUtil("OK", "Successfully Save hotel..!", null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //------------------update hotel---------------------
    @PutMapping("/update")
    public ResponseUtil updateHotel(
            @RequestParam String hotelId,
            @RequestParam String hotelLocation,
            @RequestParam String hotelName,
            @RequestParam String coordinates,
            @RequestParam String roomType,
            @RequestParam String starRate,
            @RequestParam String packageCategory,
            @RequestParam String hotelContactNumber,
            @RequestParam boolean petsAllowedOrNot,
            @RequestParam String cancelCriteria,
            @RequestParam String remarks,
            @RequestParam double hotelFee,
            @RequestParam String email,
            @RequestParam MultipartFile hotelImage
    ) {
        if (hotelImage.isEmpty()) {
            throw new RuntimeException("This Hotel Image is Empty...!");
        }
        try {
            String hotel_Image = Base64.getEncoder().encodeToString(hotelImage.getBytes());

            HotelDTO hotelDTO = new HotelDTO(

                    hotelId,
                    hotelLocation,
                    hotelName,
                    coordinates,
                    roomType,
                    starRate,
                    packageCategory,
                    hotelContactNumber,
                    petsAllowedOrNot,
                    cancelCriteria,
                    remarks,
                    hotelFee,
                    email,
                    hotel_Image
            );
            return new ResponseUtil("OK", "Successfully Save hotel..!" + hotelDTO.getHotelId(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------delete hotel----------------------------
    @DeleteMapping("id")
    public ResponseUtil deleteHotel(@RequestParam String id) {
        hotelService.deleteHotel(id);
        return new ResponseUtil("ok", "Successfully Deleted..!" + id, null);
    }

    //--------------------load the data to table------------------------------------
    @GetMapping("/loadAllHotel")
    public ResponseEntity<List<HotelRespone>> getAllHotel() {
        List<HotelRespone> hotelResponeList = hotelService.getAllHotel().stream().map(e ->
                new HotelRespone(
                        e.getHotelId(),
                        e.getHotelName(),
                        e.getHotelLocation(),
                        e.getCoordinates(),
                        e.getStarRate(),
                        e.getPackageCategory(),
                        e.getHotelContactNumberOne(),
                        e.getHotelContactNumberTwo(),
                        e.isPetsAllowedOrNot(),
                        e.getCancelCriteria(),
                        e.getHotelFee(),
                        e.getEmail()
                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(hotelResponeList, HttpStatus.OK);
    }
//-------------------Auto generate id------------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/autoGenerateId")
    public @ResponseBody CustomDTO hotelIdGenerate() {
        return hotelService.hotelIdGenerate();
    }

    //------------------------Search hotel for hotel table--------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchHotel", params = {"hotelId"})
    public HotelDTO searchHotelId(String hotel_id) {
        return hotelService.searchHotelId(hotel_id);
    }

    //-------------------------------Hotel count-----------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/hotelCount")
    public @ResponseBody CustomDTO getHotelCount(){
        return hotelService.getAllHotelCount();
    }

    //---------------------------Filter hotel details-----------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterHotel",params = {"startRate","locations"})
    public ArrayList<HotelDTO> filterHotelDetails(@RequestParam String startRate,@RequestParam String location){
        return hotelService.filterHotelDetails(startRate,location);
    }

    //-----------------------------------------------------------------
}

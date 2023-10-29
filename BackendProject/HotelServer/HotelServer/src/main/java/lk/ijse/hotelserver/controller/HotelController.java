package lk.ijse.hotelserver.controller;
import lk.ijse.hotelserver.dto.CustomDTO;
import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.service.HotelService;
import lk.ijse.hotelserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("api/v1/hotel")
@CrossOrigin(origins = "http://localhost:63342")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //------------------save hotel---------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveHotel(
            @RequestParam(value ="hotel_Id") String hotelId,
            @RequestParam(value ="hotel_Name") String hotelName,
            @RequestParam(value ="hotel_Rate") String hotelRate,
            @RequestParam(value ="hotel_Category") String hotelCategory,
            @RequestParam(value ="hotel_Location") String hotelLocation,
            @RequestParam(value ="hotel_Coordinates") String hotelCoordinates,
            @RequestParam(value ="hotel_Email") String hotelEmail,
            @RequestParam(value ="hotel_Number1") String hotelNumber1,
            @RequestParam(value ="hotel_Number2") String hotelNumber2,
            @RequestParam(value ="pets_Allowed") String petsAllowed,
            @RequestParam(value ="hotel_Fee") double hotelFee,
            @RequestParam(value ="cancellation_Criteria") String cancellationCriteria,
            @RequestParam(value ="hotel_Image") MultipartFile hotelImage
    ) {
        System.out.println( "hi: "+hotelId);
        if (hotelImage.isEmpty()) {
            throw new RuntimeException("This Hotel Image is Empty...!");
        }
        try {
            hotelService.saveHotel(new HotelDTO(
                    hotelId,
                    hotelName,
                    hotelRate,
                    hotelCategory,
                    hotelLocation,
                    hotelCoordinates,
                    hotelEmail,
                    hotelNumber1,
                    hotelNumber2,
                    petsAllowed,
                    hotelFee,
                    cancellationCriteria,
                    Base64.getEncoder().encodeToString(hotelImage.getBytes())));
            System.out.println(hotelId);
            return ResponseEntity.ok("Hotel saved successfully...!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //------------------update hotel---------------------
    @PutMapping("/update")
    public ResponseUtil updateHotel(
            @RequestParam(value ="hotel_Id") String hotelId,
            @RequestParam(value ="hotel_Name") String hotelName,
            @RequestParam(value ="hotel_Rate") String hotelRate,
            @RequestParam(value ="hotel_Category") String hotelCategory,
            @RequestParam(value ="hotel_Location") String hotelLocation,
            @RequestParam(value ="hotel_Coordinates") String hotelCoordinates,
            @RequestParam(value ="hotel_Email") String hotelEmail,
            @RequestParam(value ="hotel_Number1") String hotelNumber1,
            @RequestParam(value ="hotel_Number2") String hotelNumber2,
            @RequestParam(value ="pets_Allowed") String petsAllowed,
            @RequestParam(value ="hotel_Fee") double hotelFee,
            @RequestParam(value ="cancellation_Criteria") String cancellationCriteria,
            @RequestParam(value ="hotel_Image") MultipartFile hotelImage
    ) {
        if (hotelImage.isEmpty()) {
            throw new RuntimeException("This Hotel Image is Empty...!");
        }
        try {
            HotelDTO hotelDTO = new HotelDTO(
                    hotelId,
                    hotelName,
                    hotelRate,
                    hotelCategory,
                    hotelLocation,
                    hotelCoordinates,
                    hotelEmail,
                    hotelNumber1,
                    hotelNumber2,
                    petsAllowed,
                    hotelFee,
                    cancellationCriteria,
                    Base64.getEncoder().encodeToString(hotelImage.getBytes()));

            return new ResponseUtil("OK", "Successfully Save hotel..!" + hotelDTO.getHotelId(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------Delete hotel----------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseEntity<String> deleteHotel(@RequestParam String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully.");
    }

    //--------------------load the data to table------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllHotel")
    public ResponseUtil getAllHotel() {
        return new ResponseUtil("Ok","Successfully",hotelService.getAllHotel());
    }
//-------------------Auto generate id------------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/autoGenerateId")
    public @ResponseBody CustomDTO hotelIdGenerate() {
        return hotelService.hotelIdGenerate();
    }

    //-------------------------------Hotel count-----------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/hotelCount")
    public @ResponseBody CustomDTO getHotelCount() {
        return hotelService.getAllHotelCount();
    }

    //---------------------------Filter hotel details-----------------------------
   @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterHotel", params = {"startRate", "locations"})
    public ResponseEntity<List<HotelDTO>> filterHotelDetails(@RequestParam String startRate, @RequestParam String location) {
      return new ResponseEntity<>(hotelService.getAllHotelByStarRateAndLocation(startRate,location),HttpStatus.OK);
    }

    //-----------------------------------------------------------------
}

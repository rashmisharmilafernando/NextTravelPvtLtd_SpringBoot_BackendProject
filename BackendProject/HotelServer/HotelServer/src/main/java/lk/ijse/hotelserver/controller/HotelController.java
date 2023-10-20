package lk.ijse.hotelserver.controller;


import lk.ijse.hotelserver.dto.HotelDTO;
import lk.ijse.hotelserver.dto.HotelRespone;
import lk.ijse.hotelserver.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HotelDTO saveHotel(

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
            @RequestParam String hotelImage
    ) {
        if (hotelImage.isEmpty()) {
            throw new RuntimeException("This Hotel Image is Empty...!");
        } try {
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
                    hotelImage
            );
            return hotelService.saveHotel(hotelDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public void updateHotel(@PathVariable String hotelId,@RequestBody HotelDTO hotelDTO){
         hotelService.updateHotel(hotelId,hotelDTO);
    }

    @DeleteMapping("id")
            public void deleteHotel(String id){
        hotelService.deleteHotel(id);
    }

    @GetMapping
    public ResponseEntity<List<HotelRespone>>getAllHotel(){
        List<HotelRespone> hotelResponeList=hotelService.getAllHotel().stream().map(e ->
           new HotelRespone(
                   e.getHotelId(),
                   e.getHotelLocation(),
                   e.getHotelName(),
                   e.getCoordinates(),
                   e.getRoomType(),
                   e.getStarRate(),
                   e.getPackageCategory(),
                   e.getHotelContactNumber(),
                   e.isPetsAllowedOrNot(),
                   e.getCancelCriteria(),
                   e.getRemarks(),
                   e.getHotelFee(),
                   e.getEmail(),
                   Base64.getDecoder().decode(e.getImage())
           )
         ).collect(Collectors.toList());
        return new ResponseEntity<>(hotelResponeList,HttpStatus.OK);
    }

}

package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.BookingDTO;
import lk.ijse.packageserver.dto.BookingResponse;
import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.server.BookingService;
import lk.ijse.packageserver.server.PackageService;
import lk.ijse.packageserver.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

// The @RequestMapping annotation specifies the base URL path for this controller.
@RequestMapping("api/v1/booking")
@RestController
@CrossOrigin("*")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService, PackageService packageService) {
        this.bookingService = bookingService;
    }

    //--------------------Save----------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveBooking(@RequestBody BookingDTO bookingDTO
    ) {
       bookingService.saveBooking(bookingDTO);
       return new ResponseUtil("ok","Successfully Booking...!",null);

    }

//--------------------Update----------------------------------------------

    @PutMapping
    public ResponseUtil updateBooking( @RequestBody BookingDTO bookingDTO) {
        bookingService.updateBooking(bookingDTO);
        return new ResponseUtil("OK", "Successfully saved...!" +bookingDTO.getBookingId(), null);
    }


//---------------------Delete--------------------------------------

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteBooking(String id) {
        bookingService.deleteBooking(id);
        return new ResponseUtil("OK","Successfully Deleted...!"+id,null);
    }

//----------------------Get All Details--------------------------------------------

    @GetMapping("/loadPackages")
    public ResponseUtil getAllBooking() {
        return new ResponseUtil("Ok","Successfully",bookingService.getAllBooking());
    }


//--------------Generate Booking--------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/bookingIdGenerate")
    public @ResponseBody CustomDTO bookingIdGenerate() {
        return bookingService.generateBookingId();
    }

    //------------------count of booking-----------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/booking")
    public @ResponseBody CustomDTO getBookingCount() {
        return bookingService.getAllBookingCount();
    }

    //-------------------get booking by user id---------
    @GetMapping(params = "userId",path = "/getBookingByUserId")
    public ResponseEntity<BookingResponse> getBookingByUserId(String userId){
        return new ResponseEntity<>(bookingService.getBookingByUserId(userId),HttpStatus.OK);
    }

    //-----------get booking ids using user id--------------------
    @GetMapping(params = "userId",path = "/getBookingIdsByUserId")
    public ResponseEntity<List<String>> getBookingIdsByUserId(String userId){
        List<String> bookingIds = null;
        List<BookingResponse> bookingsByUserId = bookingService.getBookingsByUserId(userId);
        for(BookingResponse bookingGetDTO : bookingsByUserId){
            bookingIds.add(bookingGetDTO.getBookingId());
        }
        return new ResponseEntity<>(bookingIds,HttpStatus.OK);
    }
}



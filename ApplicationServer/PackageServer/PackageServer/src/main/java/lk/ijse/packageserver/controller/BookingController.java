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
    public ResponseUtil saveBooking(
            @RequestParam String bookingId,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String nightCount,
            @RequestParam String dayCount,
            @RequestParam String adultsCount,
            @RequestParam String childrenCount,
            @RequestParam double fullAmount,
            @RequestParam String paymentSlip
    ) {
        if (paymentSlip.isEmpty()) {
            throw new RuntimeException("Payment-slip is empty...!");
        }
        try {
            bookingService.saveBooking(
                    new BookingDTO(
                            bookingId,
                            startDate,
                            endDate,
                            nightCount,
                            dayCount,
                            adultsCount,
                            childrenCount,
                            fullAmount,
                            Base64.getEncoder().encodeToString(paymentSlip.getBytes())

                    ));
             return new ResponseUtil("ok","Successfully Booking...!",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//--------------------Update----------------------------------------------

    @PutMapping
    public ResponseUtil updateBooking(        @RequestParam String bookingId,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate,
                                              @RequestParam String nightCount,
                                              @RequestParam String dayCount,
                                              @RequestParam String adultsCount,
                                              @RequestParam String childrenCount,
                                              @RequestParam double fullAmount,
                                              @RequestParam String paymentSlip) {
        if (paymentSlip.isEmpty()) {
            throw new RuntimeException("Payment-slip is empty...!");
        }
        try {
            BookingDTO bookingDTO = new BookingDTO(
                    bookingId,
                    startDate,
                    endDate,
                    nightCount,
                    dayCount,
                    adultsCount,
                    childrenCount,
                    fullAmount,
                    Base64.getEncoder().encodeToString(paymentSlip.getBytes()));
            bookingService.updateBooking(bookingDTO);
            return new ResponseUtil("OK", "Successfully updated....!" + bookingDTO.getBookingId(), null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


//---------------------Delete--------------------------------------

    @DeleteMapping("id")
    public ResponseUtil deleteBooking(String id) {
        bookingService.deleteBooking(id);
        return new ResponseUtil("OK","Successfully Deleted...!"+id,null);
    }

//----------------------Get All Details--------------------------------------------

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBooking() {
        List<BookingResponse> bookingResponses = bookingService.getAllBooking().stream().map(e ->
                new BookingResponse(
                        e.getBookingId(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getNightCount(),
                        e.getDayCount(),
                        e.getAdultsCount(),
                        e.getChildrenCount(),
                        e.getFullAmount(),
                        Base64.getDecoder().decode(e.getPaymentSlip())

                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(bookingResponses, HttpStatus.OK);
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
}

    //---------------------------------------------------------


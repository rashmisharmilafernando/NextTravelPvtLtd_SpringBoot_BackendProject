package lk.ijse.packageserver.controller;

import lk.ijse.packageserver.dto.BookingDTO;
import lk.ijse.packageserver.dto.BookingResponse;
import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.server.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

// The @RequestMapping annotation specifies the base URL path for this controller.
@RequestMapping("/booking")
// The @RestController annotation indicates that this class is a RESTFull controller.
@RestController
// The @CrossOrigin annotation allows cross-origin requests from any origin.
@CrossOrigin("*")
public class BookingController {
    // A field to store an instance of the BookingService, which provides booking-related functionality.
    private final BookingService bookingService;

    // Constructor for the BookingController class, accepting an instance of BookingService.
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    //--------------------Save----------------------------------------------
    // Indicates that this method responds with an HTTP status of 201 Created
    @ResponseStatus(HttpStatus.CREATED)
    // Specifies that this method handles HTTP POST requests
    @PostMapping
    public BookingDTO saveBooking(
            // Request parameters are used to extract data from the request
            @RequestParam String bookingId,
            @RequestParam String packageId,
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
            throw new RuntimeException("Paymentslip is empty...!");
        }
        try {
            String payment_slip = Base64.getEncoder().encodeToString(paymentSlip.getBytes());
            // Create a BookingDTO object with the extracted request parameters
            BookingDTO bookingDTO = new BookingDTO(
                    bookingId,
                    packageId,
                    startDate,
                    endDate,
                    nightCount,
                    dayCount,
                    adultsCount,
                    childrenCount,
                    fullAmount,
                    payment_slip
            );
            // Call a service method to save the booking and return the result
            return bookingService.saveBooking(bookingDTO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//--------------------Update----------------------------------------------

    @PutMapping
    public void updateBooking(@PathVariable String id, @RequestBody BookingDTO bookingDTO) {
        bookingService.updateBooking(id, bookingDTO);
    }


//---------------------Delete--------------------------------------

    @DeleteMapping
    public void deleteBooking(String id) {
        bookingService.deleteBooking(id);
    }

//----------------------Get All Details--------------------------------------------

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBooking() {
        List<BookingResponse> bookingResponses = bookingService.getAllBooking().stream().map(e ->
                new BookingResponse(
                        e.getBookingId(),
                        e.getPackageId(),
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

///---------------------------------------------------------

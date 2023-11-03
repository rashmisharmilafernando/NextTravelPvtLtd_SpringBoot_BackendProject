package lk.ijse.packageserver.server;

import lk.ijse.packageserver.dto.BookingDTO;
import lk.ijse.packageserver.dto.BookingResponse;
import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


public interface BookingService {

    BookingDTO saveBooking(BookingDTO bookingDTO);

    void updateBooking(BookingDTO bookingDTO);

    void deleteBooking(String id);

    List<BookingDTO> getAllBooking();

    CustomDTO generateBookingId();

    CustomDTO getAllBookingCount();

    BookingResponse getBookingByUserId(String userId);

    List<BookingResponse> getBookingsByUserId(String userId);
}

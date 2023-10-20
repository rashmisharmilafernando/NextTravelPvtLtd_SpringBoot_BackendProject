package lk.ijse.packageserver.server;

import lk.ijse.packageserver.dto.BookingDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


public interface BookingService {

    BookingDTO saveBooking(BookingDTO bookingDTO);

    void updateBooking(String id, BookingDTO bookingDTO);

    void deleteBooking(String id);

    List<BookingDTO> getAllBooking();
}

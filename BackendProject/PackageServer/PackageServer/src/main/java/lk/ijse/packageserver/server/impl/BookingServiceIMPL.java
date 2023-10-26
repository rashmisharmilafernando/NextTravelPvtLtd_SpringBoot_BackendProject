package lk.ijse.packageserver.server.impl;

import lk.ijse.packageserver.dao.BookingDAO;
import lk.ijse.packageserver.dto.BookingDTO;
import lk.ijse.packageserver.dto.CustomDTO;
import lk.ijse.packageserver.dto.PackageDTO;
import lk.ijse.packageserver.enetity.BookingEntity;
import lk.ijse.packageserver.enetity.PackageEntity;
import lk.ijse.packageserver.server.BookingService;
import lk.ijse.packageserver.util.DataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class BookingServiceIMPL implements BookingService {

    @Autowired
    private DataConvertor dataConvertor;

    @Autowired
    private BookingDAO bookingDAO;
    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        BookingEntity bookingEntity=dataConvertor.getBookingEntity(bookingDTO);
        bookingDAO.save(bookingEntity);
        return bookingDTO;
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        bookingDAO.save(dataConvertor.getBookingEntity(bookingDTO));
    }

    @Override
    public void deleteBooking(String id) {
        bookingDAO.deleteById(id);
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return bookingDAO.findAll().stream().map(bookingEntity -> dataConvertor.getBookingDTO(bookingEntity)).collect(Collectors.toList());
    }

    @Override
    public CustomDTO generateBookingId() {
        return new CustomDTO(bookingDAO.getLastIndex());
    }

    @Override
    public CustomDTO getAllBookingCount() {
        return new CustomDTO(bookingDAO.getAllBookingCount());
    }

    @Override
    public PackageDTO getPackageById(String packageId) {
        return null;
    }
}

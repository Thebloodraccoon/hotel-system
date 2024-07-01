package ua.thecoon.hotel.service;

import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.BookingDTO;
import ua.thecoon.hotel.model.dto.HotelDTO;

import java.util.List;

public interface BookingService {
    BookingDTO getBooking(Long id) throws EntityNotFoundException;
    List<BookingDTO> getAllBookings();
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO) throws EntityNotFoundException;
    BookingDTO saveBooking(BookingDTO bookingDTO);
    boolean deleteBooking(Long id) throws EntityNotFoundException;
}

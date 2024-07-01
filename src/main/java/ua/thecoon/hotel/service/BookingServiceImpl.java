package ua.thecoon.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.BookingDTO;
import ua.thecoon.hotel.model.entity.Booking;
import ua.thecoon.hotel.model.mapper.BookingMapper;
import ua.thecoon.hotel.repo.BookingRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final BookingRepo bookingRepo;
    private final BookingMapper bookingMapper;

    @Override
    public BookingDTO getBooking(Long id) throws EntityNotFoundException {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with id: " + id));

        return bookingMapper.toBookingDTO(booking);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();

        return bookings.stream()
                .map(bookingMapper::toBookingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) throws EntityNotFoundException {
        if (!bookingRepo.existsById(id)) {
            throw new EntityNotFoundException("Booking not found with id: " + id);
        }

        Booking booking = bookingMapper.toBooking(bookingDTO);
        booking.setId(id);

        Booking updatedBooking = bookingRepo.save(booking);

        return bookingMapper.toBookingDTO(updatedBooking);
    }

    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toBooking(bookingDTO);

        Booking savedBooking = bookingRepo.save(booking);

        return bookingMapper.toBookingDTO(savedBooking);
    }

    @Override
    public boolean deleteBooking(Long id) throws EntityNotFoundException {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            return true;
        }

        throw new EntityNotFoundException("Booking not found with id: " + id);
    }
}

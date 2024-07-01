package ua.thecoon.hotel.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.BookingDTO;
import ua.thecoon.hotel.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> allBookings = bookingService.getAllBookings();

        return ResponseEntity.ok(allBookings);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) throws EntityNotFoundException {
        BookingDTO booking = bookingService.getBooking(id);

        return ResponseEntity.ok(booking);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO saveBooking = bookingService.saveBooking(bookingDTO);

        return ResponseEntity.ok(saveBooking);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id,
                                         @RequestBody BookingDTO bookingDTO) throws EntityNotFoundException {
        BookingDTO updateBooking = bookingService.updateBooking(id, bookingDTO);

        return ResponseEntity.ok(updateBooking);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteBooking(@PathVariable Long id) throws EntityNotFoundException {
        boolean b = bookingService.deleteBooking(id);

        return ResponseEntity.noContent().build();
    }
}

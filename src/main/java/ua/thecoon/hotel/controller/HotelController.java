package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();

        return ResponseEntity.ok(hotels);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Hotel> getHotelById(@PathVariable Long id) throws EntityNotFoundException {
        Hotel hotel = hotelService.getHotel(id);

        return ResponseEntity.ok(hotel);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.saveHotel(hotel);

        return ResponseEntity.ok(createdHotel);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Hotel> updateHotel(@PathVariable Long id,
                                      @RequestBody Hotel hotel) throws EntityNotFoundException {
        Hotel updatedHotel = hotelService.updateHotel(id, hotel);

        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteHotel(@PathVariable Long id) throws EntityNotFoundException {
        boolean deleted = hotelService.deleteHotel(id);

        return ResponseEntity.noContent().build();
    }
}
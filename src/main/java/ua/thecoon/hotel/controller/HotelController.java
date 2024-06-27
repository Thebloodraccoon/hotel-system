package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.HotelDTO;
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
    ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> hotels = hotelService.getAllHotels();

        return ResponseEntity.ok(hotels);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) throws EntityNotFoundException {
        HotelDTO hotel = hotelService.getHotel(id);

        return ResponseEntity.ok(hotel);
    }
}
package ua.thecoon.hotel.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.HotelDTO;
import ua.thecoon.hotel.service.HotelService;

@RestController
@RequestMapping("admin/hotels")
@RequiredArgsConstructor
public class HotelAdminController {
    private final HotelService hotelService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotel) {
        HotelDTO createdHotel = hotelService.saveHotel(hotel);

        return ResponseEntity.ok(createdHotel);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id,
                                      @RequestBody HotelDTO hotel) throws EntityNotFoundException {
        HotelDTO updatedHotel = hotelService.updateHotel(id, hotel);

        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteHotel(@PathVariable Long id) throws EntityNotFoundException {
        boolean deleted = hotelService.deleteHotel(id);

        return ResponseEntity.noContent().build();
    }
}

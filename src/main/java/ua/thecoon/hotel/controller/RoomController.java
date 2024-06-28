package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> allRooms = roomService.getAllRooms();

        return ResponseEntity.ok(allRooms);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) throws EntityNotFoundException {
        RoomDTO roomById = roomService.getRoomById(id);

        return ResponseEntity.ok(roomById);
    }


}

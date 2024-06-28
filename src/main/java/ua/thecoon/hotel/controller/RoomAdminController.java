package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.service.RoomService;

@RestController
@RequestMapping("/admin/rooms")
@RequiredArgsConstructor
public class RoomAdminController {
    private final RoomService roomService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        RoomDTO room = roomService.createRoom(roomDTO);

        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<RoomDTO> updateHotel(@PathVariable Long id,
                                         @RequestBody RoomDTO roomDTO) throws EntityNotFoundException {
        RoomDTO room = roomService.updateRoom(id, roomDTO);

        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteHotel(@PathVariable Long id) throws EntityNotFoundException {
        boolean deleteRoom = roomService.deleteRoom(id);

        return ResponseEntity.noContent().build();
    }
}

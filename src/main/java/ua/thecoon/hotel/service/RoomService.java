package ua.thecoon.hotel.service;

import ua.thecoon.hotel.model.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long id);
    RoomDTO createRoom(RoomDTO room);
    RoomDTO updateRoom(Long id, RoomDTO room);
    boolean deleteRoom(Long id);
}

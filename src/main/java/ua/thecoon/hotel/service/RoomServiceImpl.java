package ua.thecoon.hotel.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.model.entity.Room;
import ua.thecoon.hotel.model.mapper.RoomMapper;
import ua.thecoon.hotel.repo.RoomRepo;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepo roomRepo;
    private final RoomMapper roomMapper;

    public List<RoomDTO> getAllRooms() {
        List<Room> all = (List<Room>) roomRepo.findAll();

        return all.stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoomDTO getRoomById(Long id) {
        Room room = roomRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        return roomMapper.toDto(room);
    }

    @Transactional
    public RoomDTO addRoom(@Valid RoomDTO roomDTO) {
        Room room = roomMapper.toEntity(roomDTO);

        Room savedRoom = roomRepo.save(room);

        return roomMapper.toDto(savedRoom);
    }

    @Transactional
    public RoomDTO updateRoom(Long id, @Valid RoomDTO updatedRoomDTO) {
        return roomRepo.findById(id).map(room -> {
            Room updatedRoom = roomMapper.toEntity(updatedRoomDTO);

            updatedRoom.setId(room.getId());

            Room savedRoom = roomRepo.save(updatedRoom);

            return roomMapper.toDto(savedRoom);
        }).orElseThrow(() -> new EntityNotFoundException("Room not found"));
    }

    @Transactional
    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }
}
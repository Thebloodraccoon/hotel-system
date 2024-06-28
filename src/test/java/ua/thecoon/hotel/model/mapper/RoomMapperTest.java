package ua.thecoon.hotel.model.mapper;

import org.junit.jupiter.api.Test;
import ua.thecoon.hotel.model.dto.HotelItemDTO;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.entity.Room;
import ua.thecoon.hotel.model.entity.enums.RoomType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoomMapperTest extends MapperTestParent {
    @Test
    public void roomToRoomDTOTest_convertSuccessfully() {
        final Room room = new Room();

        room.setId(1L);
        room.setRoomNumber(122.5);
        room.setCapacity(1);
        room.setType(RoomType.FAMILY);
        room.setDescription("TEST");
        room.setPricePerNight(20.5);
        room.setHotel(new Hotel());


        RoomDTO roomDto = roomMapper.toRoomDto(room);

        assertNotNull(roomDto);
        assertEquals(roomDto.getId(), room.getId());
        assertEquals(roomDto.getRoomNumber(), room.getRoomNumber());
        assertEquals(roomDto.getCapacity(), room.getCapacity());
        assertEquals(roomDto.getType(), room.getType());
        assertEquals(roomDto.getDescription(), room.getDescription());
        assertEquals(roomDto.getPricePerNight(), room.getPricePerNight());
        assertNotNull(roomDto.getHotel());
    }

    @Test
    public void roomDTOToRoomTest_convertSuccessfully() {
        final RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(1L);
        roomDTO.setRoomNumber(122.5);
        roomDTO.setCapacity(1);
        roomDTO.setType(RoomType.FAMILY);
        roomDTO.setDescription("TEST");
        roomDTO.setPricePerNight(20.5);
        roomDTO.setHotel(new HotelItemDTO());


        Room room = roomMapper.toRoom(roomDTO);

        assertNotNull(room);
        assertEquals(room.getId(), roomDTO.getId());
        assertEquals(room.getRoomNumber(), roomDTO.getRoomNumber());
        assertEquals(room.getCapacity(), roomDTO.getCapacity());
        assertEquals(room.getType(), roomDTO.getType());
        assertEquals(room.getDescription(), roomDTO.getDescription());
        assertEquals(room.getPricePerNight(), roomDTO.getPricePerNight());
        assertNotNull(room.getHotel());
    }
}

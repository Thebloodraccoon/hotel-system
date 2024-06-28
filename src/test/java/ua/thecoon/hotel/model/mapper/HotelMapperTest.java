package ua.thecoon.hotel.model.mapper;

import org.junit.jupiter.api.Test;
import ua.thecoon.hotel.model.dto.GuestDTO;
import ua.thecoon.hotel.model.dto.HotelDTO;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.model.dto.UserDTO;
import ua.thecoon.hotel.model.entity.Guest;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.entity.Room;
import ua.thecoon.hotel.model.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HotelMapperTest extends MapperTestParent {
    @Test
    public void hotelToHotelDTOTest_convertSuccessfully() {
        final Hotel hotel = new Hotel();

        hotel.setId(1L);
        hotel.setName("TEST NAME");
        hotel.setAddress("TEST ADDRESS");
        hotel.setContactNum("TEST NUM");
        hotel.setRooms(List.of(new Room()));
        hotel.setUsers(List.of(new User()));
        hotel.setGuests(List.of(new Guest()));


        final HotelDTO hotelDTO = hotelMapper.toHotelDTO(hotel);

        assertNotNull(hotelDTO);
        assertEquals(hotelDTO.getId(), hotel.getId());
        assertEquals(hotelDTO.getName(), hotel.getName());
        assertEquals(hotelDTO.getAddress(), hotel.getAddress());
        assertEquals(hotelDTO.getContactNum(), hotel.getContactNum());
        assertEquals(hotelDTO.getRooms().size(), hotel.getRooms().size());
        assertEquals(hotelDTO.getUsers().size(), hotel.getUsers().size());
        assertEquals(hotelDTO.getGuests().size(), hotel.getGuests().size());
    }

    @Test
    public void hotelDTOToHotelTest_convertSuccessfully() {
        final HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setId(1L);
        hotelDTO.setName("TEST NAME");
        hotelDTO.setAddress("TEST ADDRESS");
        hotelDTO.setContactNum("TEST NUM");
        hotelDTO.setRooms(List.of(new RoomDTO()));
        hotelDTO.setUsers(List.of(new UserDTO()));
        hotelDTO.setGuests(List.of(new GuestDTO()));


        final Hotel hotel = hotelMapper.toHotel(hotelDTO);

        assertNotNull(hotel);
        assertEquals(hotel.getId(), hotelDTO.getId());
        assertEquals(hotel.getName(), hotelDTO.getName());
        assertEquals(hotel.getAddress(), hotelDTO.getAddress());
        assertEquals(hotel.getContactNum(), hotelDTO.getContactNum());
        assertEquals(hotel.getRooms().size(), hotelDTO.getRooms().size());
        assertEquals(hotel.getUsers().size(), hotelDTO.getUsers().size());
        assertEquals(hotel.getGuests().size(), hotelDTO.getGuests().size());
    }
}

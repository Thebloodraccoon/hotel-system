package ua.thecoon.hotel.model.mapper;

import org.junit.jupiter.api.Test;
import ua.thecoon.hotel.model.dto.HotelItemDTO;
import ua.thecoon.hotel.model.dto.UserDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.model.entity.enums.Role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest extends MapperTestParent {
    @Test
    public void serviceToServiceDTOTest_convertSuccessfully() {
        final User user = new User();

        user.setId(1L);
        user.setName("TEST NAME");
        user.setEmail("TEST EMAIL");
        user.setRole(Role.ADMIN);
        user.setHotel(new Hotel());
        user.setPhoneNum("TEST NUM");


        UserDTO userDTO = userMapper.toUserDto(user);

        assertNotNull(userDTO);
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPhoneNum(), user.getPhoneNum());
        assertEquals(userDTO.getRole(), user.getRole());
        assertNotNull(userDTO.getHotel());
    }

    @Test
    public void roomDTOToRoomTest_convertSuccessfully() {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(1L);
        userDTO.setName("TEST NAME");
        userDTO.setEmail("TEST EMAIL");
        userDTO.setRole(Role.ADMIN);
        userDTO.setHotel(new HotelItemDTO());
        userDTO.setPhoneNum("TEST NUM");


        User user = userMapper.toUser(userDTO);

        assertNotNull(user);
        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getPhoneNum(), userDTO.getPhoneNum());
        assertEquals(user.getRole(), userDTO.getRole());
        assertNotNull(user.getHotel());
    }
}

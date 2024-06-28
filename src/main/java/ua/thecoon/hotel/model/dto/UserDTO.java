package ua.thecoon.hotel.model.dto;

import lombok.Data;
import ua.thecoon.hotel.model.entity.enums.Role;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private Role role;
    private HotelItemDTO hotel;
}

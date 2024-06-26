package ua.thecoon.hotel.model.dto;

import lombok.Data;
import ua.thecoon.hotel.model.entity.enums.Role;

@Data
public class RegisterDTO {
    private String email;
    private String name;
    private String password;
    private String phoneNum;
    private Role roles;
    private Long hotel_id;
}

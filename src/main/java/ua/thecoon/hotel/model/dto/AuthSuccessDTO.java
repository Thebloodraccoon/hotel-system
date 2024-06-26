package ua.thecoon.hotel.model.dto;

import lombok.Data;
import ua.thecoon.hotel.model.entity.User;

@Data
public class AuthSuccessDTO {
    private User user;
    private String token;
}

package ua.thecoon.hotel.model.dto;

import lombok.Data;

@Data
public class AuthSuccessDTO {
    private UserDTO user;
    private String token;
}

package ua.thecoon.hotel.service;

import ua.thecoon.hotel.model.dto.AuthSuccessDTO;
import ua.thecoon.hotel.model.dto.LoginDTO;
import ua.thecoon.hotel.model.dto.RegisterDTO;
import ua.thecoon.hotel.model.entity.User;

public interface AuthService {
    User registerUser(RegisterDTO registerDTO) throws Exception;
    AuthSuccessDTO authenticateUser(LoginDTO loginDTO) throws Exception;
}

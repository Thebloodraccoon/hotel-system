package ua.thecoon.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.UserNotAuthenticatedException;
import ua.thecoon.hotel.model.dto.AuthSuccessDTO;
import ua.thecoon.hotel.model.dto.LoginDTO;
import ua.thecoon.hotel.model.dto.RegisterDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.repo.HotelRepo;
import ua.thecoon.hotel.repo.UserRepo;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final HotelRepo hotelRepo;

    public User registerUser(RegisterDTO registerDTO) throws Exception {
        Optional<Hotel> hotel = hotelRepo.findById(registerDTO.getHotel_id());


        User user = User.builder()
                .email(registerDTO.getEmail())
                .password(registerDTO.getPassword())
                .name(registerDTO.getName())
                .role(registerDTO.getRoles())
                .hotel(hotel.get())
                .build();

        return userRepo.save(user);
    }

    public AuthSuccessDTO authenticateUser(LoginDTO loginDTO) throws Exception {
        User userByEmail = userRepo.findUserByEmail(loginDTO.getEmail());

        if (userByEmail != null && userByEmail.getPassword().equals(loginDTO.getPassword())) {
            AuthSuccessDTO authSuccessDTO = new AuthSuccessDTO();
            authSuccessDTO.setUser(userByEmail);
            return authSuccessDTO;
        }

        throw new UserNotAuthenticatedException("Login data is incorrect");
    }
}

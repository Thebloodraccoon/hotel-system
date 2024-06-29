package ua.thecoon.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.UserNotAuthenticatedException;
import ua.thecoon.hotel.model.dto.AuthSuccessDTO;
import ua.thecoon.hotel.model.dto.LoginDTO;
import ua.thecoon.hotel.model.dto.RegisterDTO;
import ua.thecoon.hotel.model.dto.UserDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.model.mapper.UserMapper;
import ua.thecoon.hotel.repo.HotelRepo;
import ua.thecoon.hotel.repo.UserRepo;
import ua.thecoon.hotel.security.model.HotelUserDetails;
import ua.thecoon.hotel.security.util.JwtUtil;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final HotelRepo hotelRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    public UserDTO registerUser(RegisterDTO registerDTO) throws Exception {
        Optional<Hotel> hotel = hotelRepo.findById(registerDTO.getHotelId());

        String pass = encoder.encode(registerDTO.getPassword());

        User user = User.builder()
                .email(registerDTO.getEmail())
                .password(pass)
                .name(registerDTO.getName())
                .role(registerDTO.getRoles())
                .phoneNum(registerDTO.getPhoneNum())
                .hotel(hotel.get())
                .build();

        User save = userRepo.save(user);

        return userMapper.toUserDto(save);
    }

    public AuthSuccessDTO authenticateUser(LoginDTO loginDTO) throws Exception {
        UserDetails authUser = org.springframework.security.core.userdetails.User
                .withUsername(loginDTO.getEmail())
                .password(loginDTO.getPassword())
                .build();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authUser, loginDTO.getPassword()));

        HotelUserDetails principal = (HotelUserDetails) authentication.getPrincipal();

        if (principal != null) {
            String passwordHash = principal.getPassword();
            boolean matches = encoder.matches(loginDTO.getPassword(), passwordHash);

            if (matches) {
                String token = jwtUtil.generateToken(principal);

                AuthSuccessDTO authSuccessDTO = new AuthSuccessDTO();
                authSuccessDTO.setUser(userMapper.toUserDto(principal.getHotelUser()));
                authSuccessDTO.setToken(token);


                return authSuccessDTO;
            }
        }

        throw new UserNotAuthenticatedException("Login data is incorrect");
    }
}

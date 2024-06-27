package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.model.dto.AuthSuccessDTO;
import ua.thecoon.hotel.model.dto.LoginDTO;
import ua.thecoon.hotel.model.dto.RegisterDTO;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public  @ResponseBody
    ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) throws Exception {
        User user = authService.registerUser(registerDTO);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) throws Exception {
        AuthSuccessDTO authSuccess = authService.authenticateUser(loginDTO);

        return ResponseEntity.ok(authSuccess.getUser());
    }
}

package com.studeis.tomcat.social_network.security.controllers;

import com.studeis.tomcat.social_network.dto.user.UserRequestDTO;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.security.JWT.JwtService;
import com.studeis.tomcat.social_network.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequestDTO dto) {
        userService.createUser(dto);
        return "User registered!";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserRequestDTO dto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
        ));

        User user = userService.getUserByUsername(dto.getUsername());

        String token = jwtService.generateToken(dto.getUsername());
        var userId = userService.getUserByUsername(dto.getUsername());
        String role = (user.getRole() != null) ? user.getRole().name() : "USER";

        return Map.of(
                "token", token,
                "userId", userId,
                "roles", role);
    }
}
package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.dto.user.UserRequestDTO;
import com.studeis.tomcat.social_network.dto.user.UserResponseDTO;
import com.studeis.tomcat.social_network.models.Role;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public Optional<UserResponseDTO> getUserByID(Long id) {
        return userRepository.findById(id)
                .map(this::toResponseDTO);
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = toEntity(dto);
        userRepository.save(user);
        return toResponseDTO(user);
    }

    public UserResponseDTO updateUser(UserRequestDTO dto, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(dto.getUsername());
                    user.setEmail(dto.getEmail());
                    user.setBio(dto.getBio());
                    user.setImageUrl(dto.getImageUrl());
                    if (dto.getPassword() != null) user.setPassword(passwordEncoder.encode(dto.getPassword()));
                    return toResponseDTO(userRepository.save(user));
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDTO getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setBio(dto.getBio());
        user.setImageUrl(dto.getImageUrl());

        user.setRole(dto.getRole() != null ? dto.getRole() : Role.USER);
        return user;
    }

    private UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO(
                user.getId(), user.getUsername(),
                user.getEmail(), user.getBio(),
                user.getImageUrl(), user.getRole());

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setBio(user.getBio());
        dto.setImageUrl(user.getImageUrl());
        dto.setRole(user.getRole());
        return dto;
    }
}
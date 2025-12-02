package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.follower.FollowResponseDTO;
import com.studeis.tomcat.social_network.dto.user.UserRequestDTO;
import com.studeis.tomcat.social_network.dto.user.UserResponseDTO;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import com.studeis.tomcat.social_network.security.JWT.JwtService;
import com.studeis.tomcat.social_network.services.FollowService;
import com.studeis.tomcat.social_network.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final FollowService followService;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserController(UserService userService,  FollowService followService,
                          JwtService jwtService,  UserRepository userRepository) {
        this.userService = userService;
        this.followService = followService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    // Get
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.getUserByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/profile")
    public UserResponseDTO getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.getUserByUsername(username);
    }

    // Post
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id,
                                      @RequestBody UserRequestDTO dto) {
        return userService.updateUser(dto, id);
    }

    // Del
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    // Follow
    @PostMapping("/{followId}/follow")
    public FollowResponseDTO followUser(@PathVariable Long followId, @RequestParam Long followerId) {
        return followService.follow(followerId, followId);
    }

    @DeleteMapping("/{followId}/follow")
    public void unfolowUser(@PathVariable Long followId, @RequestParam Long followerId) {
        followService.unfollow(followerId, followId);
    }

    @GetMapping("/{followId}/followers")
    public List<FollowResponseDTO> getFollowers(@PathVariable Long followId) {
        return followService.getFollowers(followId);
    }

    @GetMapping("/{followingId}/following")
    public List<FollowResponseDTO> getFollowing(@PathVariable Long followingId) {
        return followService.getFollowing(followingId);
    }
}
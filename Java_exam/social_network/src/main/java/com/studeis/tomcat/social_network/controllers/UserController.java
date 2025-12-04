package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.follower.FollowResponseDTO;
import com.studeis.tomcat.social_network.dto.user.UserRequestDTO;
import com.studeis.tomcat.social_network.dto.user.UserResponseDTO;
import com.studeis.tomcat.social_network.services.FollowService;
import com.studeis.tomcat.social_network.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final FollowService followService;

    public UserController(UserService userService,  FollowService followService) {
        this.userService = userService;
        this.followService = followService;
    }

    // Get
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/profile")
    public UserResponseDTO getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.getUserByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Post/Put
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

//    @PutMapping("/{id}")
//    public UserResponseDTO updateUser(@PathVariable Long id,
//                                      @RequestBody UserRequestDTO dto) {
//        return userService.updateUser(dto, id);
//    }

    @PutMapping(value = "/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserResponseDTO updateProfile(
            @RequestPart("data") UserRequestDTO dto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.updateCurrentUser(dto, image, username);
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
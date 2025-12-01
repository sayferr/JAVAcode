package com.studeis.tomcat.social_network.dto.user;

import com.studeis.tomcat.social_network.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String imageUrl;

    private Role role;

    //Test
    public  UserResponseDTO() {
        this.id = id;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.role = role;
    }
}
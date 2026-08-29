package com.studeis.tomcat.social_network.dto.user;

import com.studeis.tomcat.social_network.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
    private String bio;
    private String imageUrl;

    private Role role;

    //Test
    public  UserRequestDTO(String username, String password, String email, String bio, String imageUrl, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.imageUrl = imageUrl;

        this.role = role;
    }
}

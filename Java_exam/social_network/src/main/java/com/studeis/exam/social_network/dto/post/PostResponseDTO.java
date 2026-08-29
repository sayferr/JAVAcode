package com.studeis.tomcat.social_network.dto.post;

import com.studeis.tomcat.social_network.dto.user.UserSummaryDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostResponseDTO {
    private Long id;
    private String content;
    private String imageUrl;
    private String createdAt;

    private Long userId;
    private String username;
    private UserSummaryDTO user;
    private String userAvatar;

    private int likesCount;
    private int commentsCount;
}
package com.studeis.tomcat.social_network.dto.follower;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class FollowResponseDTO {
    private Long id;
    private Long followerId;
    private Long followingId;
    private LocalDateTime createdAt;
    private String username;
    private String avatarUrl;


    public FollowResponseDTO(Long id, Long followerId, Long followingId, LocalDateTime createdAt) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
        this.createdAt = createdAt;
    }

    public FollowResponseDTO(Long id, Long userId, String username, String avatarUrl, LocalDateTime createdAt) {
        this.id = id;
        this.followerId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
    }

    public FollowResponseDTO() {}
}
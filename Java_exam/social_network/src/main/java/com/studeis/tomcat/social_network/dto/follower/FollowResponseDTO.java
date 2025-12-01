package com.studeis.tomcat.social_network.dto.follower;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FollowResponseDTO {
    Long id;
    Long followerId;
    Long followingId;
    Long createdAt;

    public FollowResponseDTO(Long id, Long followerId, Long followingId, LocalDateTime createdAt) {
    }
}

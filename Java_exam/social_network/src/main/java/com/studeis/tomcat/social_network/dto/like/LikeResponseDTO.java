package com.studeis.tomcat.social_network.dto.like;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LikeResponseDTO {
    Long id;
    Long userId;
    Long postId;
    LocalDateTime createdAt;

    public LikeResponseDTO(Long id, Long userId, Long postId, LocalDateTime createdAt) {
    }
}

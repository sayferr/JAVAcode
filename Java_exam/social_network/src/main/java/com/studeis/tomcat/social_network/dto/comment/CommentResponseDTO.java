package com.studeis.tomcat.social_network.dto.comment;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {
    private Long id;
    private String content;
    private String createdAt;
    private Long userId;
    private Long postId;
}

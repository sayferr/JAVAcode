package com.studeis.tomcat.social_network.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String content;
    private Long userId;
    private Long postId;
}

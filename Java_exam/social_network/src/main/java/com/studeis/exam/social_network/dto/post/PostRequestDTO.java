package com.studeis.tomcat.social_network.dto.post;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {
    private String content;
    private String imageUrl;
    private Long userId;
}

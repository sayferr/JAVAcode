package com.studeis.tomcat.social_network.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequestDTO {
    private Long senderId;
    private Long receiverId;
    private String content;
}

package com.studeis.tomcat.social_network.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSummaryDTO {
    private Long id;
    private String username;
    private String imageUrl;
}

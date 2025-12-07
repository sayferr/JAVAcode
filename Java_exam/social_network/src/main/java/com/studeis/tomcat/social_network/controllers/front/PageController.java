package com.studeis.tomcat.social_network.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/edit_profile")
    public String editPage() {
        return "edit_profile";
    }

    @GetMapping("/post")
    public String postsPage() {
        return "post";
    }
}
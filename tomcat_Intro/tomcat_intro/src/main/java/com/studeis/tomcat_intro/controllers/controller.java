package com.studeis.tomcat_intro.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class controller {

    @GetMapping("/users")
    public List<String> users(){
        return List.of("user1", "user2", "user3");
    }
}

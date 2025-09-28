package com.studeis.mysql_intro.repositories.contollers;

import com.studeis.mysql_intro.repositories.DTOs.userDTO;
import com.studeis.mysql_intro.repositories.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class homeController {

    @Autowired
    private userServices userServices;

    @GetMapping("/")
    public List<userDTO> getAll(){
       return userServices.findAll();
    }
}

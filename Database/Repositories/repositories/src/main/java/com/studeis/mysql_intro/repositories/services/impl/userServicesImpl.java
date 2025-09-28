package com.studeis.mysql_intro.repositories.services.impl;

import com.studeis.mysql_intro.repositories.entities.User;
import com.studeis.mysql_intro.repositories.services.userServices;
import com.studeis.mysql_intro.repositories.userRepository;
import com.studeis.mysql_intro.repositories.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studeis.mysql_intro.repositories.DTOs.userDTO;

import java.util.List;

@Service
public class userServicesImpl implements userServices {

    @Autowired
    private userRepository userRepository;

    @Override
    public List<userDTO> findAll() {
        Iterable<User> all = userRepository.findAll();
        return Converter.convert(all);
    }
}

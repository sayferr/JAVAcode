package com.studeis.mysql_intro.repositories.utils;

import com.studeis.mysql_intro.repositories.DTOs.userDTO;
import com.studeis.mysql_intro.repositories.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Converter {
    public static List<userDTO> convert(Iterable<User> iterable){
        List<userDTO> list = new ArrayList<>((Collection) iterable);
        return list;
    }
}

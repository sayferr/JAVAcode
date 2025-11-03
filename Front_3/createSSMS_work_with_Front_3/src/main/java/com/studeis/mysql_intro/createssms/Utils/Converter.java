package com.studeis.mysql_intro.createssms.Utils;

import com.studeis.mysql_intro.createssms.DTOs.TeacherDTO;
import com.studeis.mysql_intro.createssms.entityDB.teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Converter {
    public static List<TeacherDTO> convert(Iterable<teacher> iterable) {
        List<TeacherDTO> list = new ArrayList<>((Collection) iterable);
        return list;
    }
}

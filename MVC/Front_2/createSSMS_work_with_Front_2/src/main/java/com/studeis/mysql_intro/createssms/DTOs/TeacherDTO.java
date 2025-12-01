package com.studeis.mysql_intro.createssms.DTOs;

import com.studeis.mysql_intro.createssms.entityDB.teacher;

public class TeacherDTO {
    private Long id;
    private String name;
    private String surname;

    public TeacherDTO(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public TeacherDTO(teacher teacher) {
        id = Long.valueOf(teacher.getId());
        name = teacher.getName();
        surname = teacher.getSurname();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

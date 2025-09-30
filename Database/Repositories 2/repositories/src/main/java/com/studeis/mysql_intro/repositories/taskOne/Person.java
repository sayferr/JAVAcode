package com.studeis.mysql_intro.repositories.taskOne;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "person",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Person {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}

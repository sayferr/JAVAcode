package com.studeis.mysql_intro.repositories.ManyToMany.second;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students =  new HashSet<>();
}

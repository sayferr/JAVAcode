package com.studeis.mysql_intro.repositories.OneToMany.first;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books =  new ArrayList<>();
}

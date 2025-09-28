package com.studeis.mysql_intro.repositories.OneToMany.first;

import jakarta.persistence.*;

@Entity
@Table(name = "Book",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String year;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}

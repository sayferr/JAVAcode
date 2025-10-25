package com.studeis.mysql_intro.createssms.entityDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Groups",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class groupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10,unique = true)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Integer rating;

    @Column(nullable = false, name = "year")
    @Min(1)
    @Max(5)
    private Integer year;
}

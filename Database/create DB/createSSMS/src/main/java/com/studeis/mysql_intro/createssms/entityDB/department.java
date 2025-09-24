package com.studeis.mysql_intro.createssms.entityDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Departments",
                uniqueConstraints = {@UniqueConstraint(columnNames = "name")})

public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Min(0)
    private Double financing = 0.0;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

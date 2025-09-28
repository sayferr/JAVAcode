package com.studeis.mysql_intro.repositories.OneToOne.First;

import jakarta.persistence.*;

@Entity
@Table(name = "Work_station",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class workStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, name = "position")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @OneToOne(mappedBy = "workstation")
    private Employee employee;
}

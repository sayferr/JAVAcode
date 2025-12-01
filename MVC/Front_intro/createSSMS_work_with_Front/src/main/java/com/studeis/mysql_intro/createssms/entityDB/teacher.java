package com.studeis.mysql_intro.createssms.entityDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "Teachers",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class teacher {

    private Integer age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employment_data", nullable = false)
    @PastOrPresent
    private LocalDate employmentData;

    @Column(nullable = false, name = "is_assistent")
    private Boolean isAssistent = false;

    @Column(nullable = false, name = "is_professor")
    private Boolean isProfessor = false;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String surname;

    @Column(nullable = false)
    @NotBlank
    private String position;

    @Column(nullable = false)
    @NotBlank
    private String salary;

    public teacher(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public teacher() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getEmploymentData() {
        return employmentData;
    }

    public void setEmploymentData(LocalDate employmentData) {
        this.employmentData = employmentData;
    }

    public Boolean getAssistent() {
        return isAssistent;
    }

    public void setAssistent(Boolean assistent) {
        isAssistent = assistent;
    }

    public Boolean getProfessor() {
        return isProfessor;
    }

    public void setProfessor(Boolean professor) {
        isProfessor = professor;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

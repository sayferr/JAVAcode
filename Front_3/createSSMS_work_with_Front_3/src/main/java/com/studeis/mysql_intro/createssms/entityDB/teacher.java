package com.studeis.mysql_intro.createssms.entityDB;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "Teachers",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class teacher {

    @Min(value = 18)
    @Max(value = 90)
    private Integer age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employment_data"/**, nullable = false */)
    @PastOrPresent
    private LocalDate employmentData;

    @Column(/**, nullable = false */ name = "is_assistent")
    private Boolean isAssistent = false;

    @Column(/**, nullable = false */ name = "is_professor")
    private Boolean isProfessor = false;

//    @Column(nullable = false)
//    @NotBlank
    private String name;

//    @Column(nullable = false)
//    @NotBlank
    private String surname;

//    @Column(nullable = false)
//    @NotBlank
    private String position;

//    @Column(nullable = false)
//    @NotBlank
    private Integer salary;

    public teacher(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

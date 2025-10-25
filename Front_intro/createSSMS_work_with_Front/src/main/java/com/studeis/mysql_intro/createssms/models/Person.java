package com.studeis.mysql_intro.createssms.models;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer id;
    private Boolean isMan = false;
    private static Integer count = 1;
    private TypeUser typeUser;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = count++;
        this.typeUser = TypeUser.OK;
    }

    public Boolean getMan() {
        return isMan;
    }

    public void setMan(Boolean man) {
        isMan = man;
    }

    public String getTypeUser() {
        return typeUser.name();
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public Boolean getIsMan() {
        return isMan;
    }

    public void setIsMan(Boolean isMan) {
        this.isMan = isMan;
    }

    public Person() {
        this.id = count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Person.count = count;
    }
}

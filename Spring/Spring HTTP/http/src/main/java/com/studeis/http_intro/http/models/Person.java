package com.studeis.http_intro.http.models;

public class Person {
        private String firstName;
        private  String lastName;
        private  String email;
        private int age;
        private int id;
        private static int count = 1;

        public Person(String firstName, String lastName, String email, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.age = age;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
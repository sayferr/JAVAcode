package com.studeis.http_intro.http.controllers;

import com.studeis.http_intro.http.models.Person;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/home")

public class HomeController {

    private List<Person> people;

    public HomeController() {
        people = new ArrayList<>();
        people.add(new Person("Roman", "S", "s@gamil.com", 20));
        people.add(new Person("Kamilla", "H", "H@gmail.com", 20));
        people.add(new Person("David", "M", "M@gmail.com", 20));
    }

    @GetMapping("/search")
    public List<Person> getSurnamePeople(@RequestParam String surname) {
        return people.stream()
                .filter(p -> p.getLastName().equalsIgnoreCase(surname))
                .toList();
    }

    @GetMapping("/filter")
    public List<Person> FilterByAge(@RequestParam int min, @RequestParam int max) {
        return people.stream()
                .filter(p -> p.getAge() >= min && p.getAge() <= max)
                .toList();
    }

    @GetMapping("/sort")
    public List<Person> Sort(@RequestParam String by, @RequestParam String dir){
        Comparator<Person> comparator;

        switch (by.toLowerCase()){
            case "name" -> comparator = Comparator.comparing(Person::getLastName);
            case "surname" -> comparator = Comparator.comparing(Person::getLastName);
            case "age" -> comparator = Comparator.comparing(Person::getAge);
            default -> throw new IllegalArgumentException("Invalid by");
        }
        if (dir.equalsIgnoreCase("desc")){
            comparator = comparator.reversed();
        }
        return people.stream().sorted(comparator)/**.filter(p -> p.getLastName().equalsIgnoreCase(dir))*/.toList();
    }


    @PostMapping("/")
    public Boolean AddPeople(@RequestBody Person person) {
        if (person.getFirstName() == null || person.getLastName() == null ||
                person.getAge() < 0 || person.getAge() > 100) {
            return false;
        }
        return people.add(person);
    }

    @DeleteMapping("/deletebysurname")
    public int DeleteBySurname(@RequestParam String surname) {
        int before = people.size();
        people.removeIf(p -> p.getLastName().equalsIgnoreCase(surname));
        return before - people.size();
    }


    @GetMapping("/youngest")
    public Person getYoungestPeople() {
        return people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }
    @GetMapping("/oldest")
    public Person getOldestPeople() {
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }
}

//GET - all +
//GET(return) - {id} +
//POST(send new object) - /... +
//PUT(update) - {id} +
//DELETE - {id} +

package com.studeis.crud_spring.controllers;


import com.studeis.crud_spring.models.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private Map<Long, Person> persons = new HashMap<>();
    private Long counter = 1L;

    @PostMapping //Create
    public Person create(@RequestBody Person person) {
        person.setId(counter++);
        persons.put(person.getId(), person);
        return person;
    }

    @GetMapping("/persons") //Read(All)
    public Collection<Person> getAll() {
        return persons.values();
    }

    @GetMapping ("/{id}")//Read(By ID)
    public Person getOne(@PathVariable Long id) {
        return persons.get(id);

//        Person person = persons.get(id);
//        if (person == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")//Update
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    @DeleteMapping("/{id}")//Delete
    public void delete(@PathVariable Long id) {
        persons.remove(id);
    }
}

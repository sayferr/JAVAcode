package com.studeis.mysql_intro.repositories.taskOne.Services;

import com.studeis.mysql_intro.repositories.taskOne.Person;
import com.studeis.mysql_intro.repositories.taskOne.personRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class personService {
    private personRepository personRepository;

    public personService(personRepository personRepository) {
        this.personRepository = personRepository;
    }
    // 1
    public Iterable<Person> findAllSortedByFirstNameAsc() {
        return personRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }
    // 2
    public Iterable<Person> findAllSortedByAgeDesc() {
        return personRepository.findAll(Sort.by(Sort.Direction.DESC, "age"));
    }
    // 3
    public Page<Person> findFirstPageSortedById() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id"));
        return personRepository.findAll(pageable);
    }
    // 4
    public Page<Person> findSecondPageSortedByLastName() {
        Pageable pageable = PageRequest.of(1, 10, Sort.by("lastName"));
        return personRepository.findAll(pageable);
    }
    // 5
    public Page<Person> findAdults(Pageable pageable) {
        return personRepository.findByAge(18, pageable);
    }
    // 6
    public Page<Person> findByLastName(String lastName, Pageable pageable) {
        return personRepository.findByLastName(lastName, pageable);
    }
    // 7)
    public Iterable<Person> findAllSortedByAgeAndLastName() {
        return personRepository.findAll(Sort.by("age").and(Sort.by("lastName")));
    }
    // 8
    public Page<Person> findByGmail(Pageable pageable) {
        return personRepository.findByEmailContaining("gmail.com", pageable);
    }
    // 9
    public Page<Person> findByAgeRange(Pageable pageable) {
        return personRepository.findByAgeBetween(20, 40, pageable);
    }
    // 10
    public Page<Person> searchByNameWithPaging(String name, Pageable pageable) {
        return personRepository.findByFirstNameContaining(name, pageable);
    }
}

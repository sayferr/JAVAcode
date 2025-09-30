package com.studeis.mysql_intro.repositories.taskOne;

import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepository extends JpaRepository<Person,Long> {

    org.springframework.data.domain.Page<Person> findByAge(int age, Pageable pageable);
    org.springframework.data.domain.Page<Person> findByLastName(String firstName, Pageable pageable);
   //Page<Person> findByLastName(String firstName, Pageable pageable);
   org.springframework.data.domain.Page<Person> findByEmailContaining(String email, Pageable pageable);
   org.springframework.data.domain.Page<Person> findByAgeBetween(int min, int max, Pageable pageable);
   org.springframework.data.domain.Page<Person> findByFirstNameContaining(String firstName,  Pageable pageable);

}
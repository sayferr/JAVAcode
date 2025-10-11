package com.studeis.junit.intro_junit.repositories;

import com.studeis.junit.intro_junit.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRepository extends JpaRepository<Author,Long> {
}

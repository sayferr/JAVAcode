package com.studeis.junit.intro_junit.repositories;

import com.studeis.junit.intro_junit.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book,Long> {
}

package com.studeis.junit.intro_Shedule.repositories;

import com.studeis.junit.intro_Shedule.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book,Long> {
}

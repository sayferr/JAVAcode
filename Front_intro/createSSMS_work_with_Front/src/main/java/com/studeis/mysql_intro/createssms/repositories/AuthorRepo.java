package com.studeis.mysql_intro.createssms.repositories;

import com.studeis.mysql_intro.createssms.entityDB.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface AuthorRepo extends JpaRepository<Author,Long> {
}

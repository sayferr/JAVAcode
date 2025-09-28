package com.studeis.mysql_intro.repositories;

import com.studeis.mysql_intro.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<User, Long> {
// Было JpaRepository, но на время задания поменял на CrudRepository
}

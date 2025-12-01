package com.studeis.mysql_intro.createssms.repositories;

import com.studeis.mysql_intro.createssms.entityDB.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<teacher, Long> {
    @Query(value = " exec getTeacherAbove30  ",nativeQuery = true)
    List<teacher> skubidu( );
}


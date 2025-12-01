package com.studeis.mysql_intro.createssms.repositories;

import com.studeis.mysql_intro.createssms.entityDB.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<teacher, Long> {
//    @Query(value = " SELECT * FROM teacher WHERE CONCAT (id, '-', Name, '-', Surname, '-', age) like '%:str%'",
//            nativeQuery = true)
//    List<teacher> findAllByStr(@Param ("str") String str);

    @Query("SELECT t FROM teacher t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(t.surname) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<teacher> findAllByStr(@Param("search") String search);
}
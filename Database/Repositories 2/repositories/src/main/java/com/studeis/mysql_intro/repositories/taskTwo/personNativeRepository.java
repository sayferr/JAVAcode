package com.studeis.mysql_intro.repositories.taskTwo;

import com.studeis.mysql_intro.repositories.taskOne.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personNativeRepository extends JpaRepository<Person,Long> {
    // SELECT (native)
    @Query(value = "SELECT * FROM persons WHERE email LIKE '%@gmail.com'", nativeQuery = true)
    List<Person> findAllWithGmail();

    // SELECT + JOIN (native)
    @Query(value = """
            SELECT p.id AS id, p.first_name AS firstName, c.name AS cityName
            FROM persons p
            JOIN cities c ON p.city_id = c.id
            """, nativeQuery = true)
    List<personCityProjection> findPersonsWithCity();

    // SELECT + агрегаты (native)
    @Query(value = """
            SELECT p.last_name AS lastName, COUNT(*) AS cnt
            FROM persons p
            GROUP BY p.last_name
            ORDER BY cnt DESC
            """, nativeQuery = true)
    List<lastNameCountProjection> countByLastName();

    // Пагинация (SQL Server синтаксис OFFSET FETCH)
    @Query(value = """
            SELECT * FROM persons
            ORDER BY id
            OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY
            """, nativeQuery = true)
    List<Person> findWithPagination(@Param("offset") int offset, @Param("size") int size);

    // UPDATE
    @Modifying
    @Query(value = """
            UPDATE persons
            SET age = age + :delta
            WHERE age < :maxAge
            """, nativeQuery = true)
    int increaseAge(@Param("delta") int delta, @Param("maxAge") int maxAge);

    // DELETE
    @Modifying
    @Query(value = "DELETE FROM persons WHERE age < :age", nativeQuery = true)
    int deleteYoungerThan(@Param("age") int age);

    // INSERT
    @Modifying
    @Query(value = "INSERT INTO persons(first_name, last_name, email, age) VALUES (:firstName, :lastName, :email, :age)", nativeQuery = true)
    int insertPerson(@Param("firstName") String firstName,
                     @Param("lastName") String lastName,
                     @Param("email") String email,
                     @Param("age") int age);

    // EXEC без параметров
    @Query(value = "EXEC GetPersonsAbove10", nativeQuery = true)
    List<Person> callGetPersonsAbove10();

    // EXEC с IN-параметром
    @Query(value = "EXEC GetPersonsAboveAge :minAge", nativeQuery = true)
    List<Person> callGetPersonsAboveAge(@Param("minAge") int minAge);
}

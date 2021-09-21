package ru.netology.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.demo.dao.Person;
import ru.netology.demo.dao.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String city);

    @Query("select p from Person p where p.age < :age order by p.age")
    List<Person> findByAge(@Param("age") Integer age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}

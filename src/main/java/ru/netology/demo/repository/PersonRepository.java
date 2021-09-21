package ru.netology.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.demo.dao.Person;
import ru.netology.demo.dao.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String cityOfLiving);
    List<Person> findByAgeLessThanOrderByAge(Integer age);
    Optional<Person> findByNameAndSurname(String name, String surname);
}

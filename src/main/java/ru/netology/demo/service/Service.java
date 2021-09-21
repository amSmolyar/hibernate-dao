package ru.netology.demo.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.demo.dao.Person;
import ru.netology.demo.repository.Repository;

import java.util.List;

public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Person> getPersonsByAge(Integer age) {
        return repository.getPersonsByAge(age);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        return repository.getPersonByNameAndSurname(name, surname)
                .orElseThrow(() -> new RuntimeException("no person found"));
    }
}

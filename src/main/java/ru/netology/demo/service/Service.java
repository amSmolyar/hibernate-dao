package ru.netology.demo.service;

import ru.netology.demo.dao.Person;
import ru.netology.demo.repository.Repository;

import java.util.List;

public class Service {
    private Repository repository;
    private static int cntInitTableRequest = 0;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Person> getPersons() {
        cntInitTableRequest++;
        if (cntInitTableRequest > 1) {
            return repository.getPersons();
        } else {
            return repository.savePersons();
        }
    }
}

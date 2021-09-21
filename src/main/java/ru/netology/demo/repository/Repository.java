package ru.netology.demo.repository;

import lombok.var;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import ru.netology.demo.dao.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class Repository {

    private PersonRepository personRepository;

    @Autowired
    public Repository(PersonRepository personRepository) {
        this.personRepository = personRepository;
        savePersons();
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }

    @Transactional
    public List<Person> getPersonsByAge(Integer age) {
        return personRepository.findByAge(age);
    }

    @Transactional
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @Transactional
    public void savePersons() {
        Random random = new Random();

        var names = Arrays.asList("Evgeniy", "Pavel", "Olga", "Mihail", "Stepan", "Alexey", "Ivan", "Igor");
        var surnames = Arrays.asList("Smith", "Black", "White", "Brown", "Green", "Red");
        var cities = Arrays.asList("Moscow", "Sevastopol", "Murmansk");

        IntStream.range(0, 10)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("+79" + random.nextInt(999999999))
                            .build();

                    personRepository.save(person);
                });

    }
}

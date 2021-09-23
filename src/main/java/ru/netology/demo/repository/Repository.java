package ru.netology.demo.repository;

import lombok.var;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import ru.netology.demo.dao.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public Repository() {
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city_of_living", Person.class);
        query.setParameter("city_of_living", city);
        List<Person> list = query.getResultList();
        return list;
    }

    @Transactional
    public List<Person> savePersons() {
        Random random = new Random();

        var names = Arrays.asList("Evgeniy", "Pavel", "Olga", "Mihail", "Stepan", "Alexey", "Ivan", "Igor");
        var surnames = Arrays.asList("Smith", "Black", "White", "Brown", "Green", "Red");
        var cities = Arrays.asList("Moscow", "Sevastopol", "Murmansk");

        IntStream.range(0, 100)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("+79" + random.nextInt(999999999))
                            .build();

                    this.entityManager.persist(person);
                });

        var query = entityManager.createQuery("select p from Person p", Person.class);
        List<Person> list = query.getResultList();
        return list;
    }
}

package ru.netology.demo.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.demo.dao.Person;
import ru.netology.demo.service.Service;

import java.util.List;

@RestController
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByCity(@RequestParam("age") Integer age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Person getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

}

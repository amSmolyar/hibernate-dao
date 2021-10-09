package ru.netology.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.netology.demo.dao.Person;
import ru.netology.demo.service.Service;

import javax.annotation.security.RolesAllowed;
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

    @GetMapping("/persons/by-name-surname/for-user")
    @Secured("ROLE_USER")
    public Person getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
        return service.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-name-surname/for-staff")
    @RolesAllowed("ROLE_STAFF")
    public Person getPersonByNameAndSurname1(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
        return service.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-name-surname/for-staff-admin")
    @PreAuthorize("hasRole('ROLE_STAFF') or hasRole('ROLE_ADMIN')")
    public Person getPersonByNameAndSurname2(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
        return service.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-name-surname/for-staff-admin2")
    @PostAuthorize("hasRole('ROLE_STAFF') or hasRole('ROLE_ADMIN')")
    public Person getPersonByNameAndSurname3(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
        return service.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-name-surname/for-username")
    @PreAuthorize("#username==authentication.principal.username")
    public Person getPersonByNameAndSurname4(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
        return service.getPersonByNameAndSurname(name, surname);
    }


//    @GetMapping("/persons/by-name-surname")
//    public Person getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
//        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " works with table");
//        return service.getPersonByNameAndSurname(name, surname);
//    }

}

package ru.netology.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.demo.repository.PersonRepository;
import ru.netology.demo.repository.Repository;
import ru.netology.demo.service.Service;

@Configuration
public class JavaConfig {


    @Bean
    public Repository repository(PersonRepository personRepository) {
        return new Repository(personRepository);
    }

    @Bean
    public Service service(Repository repository) {
        return new Service(repository);
    }
}

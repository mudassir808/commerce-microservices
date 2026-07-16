package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository repository) {

        return args -> {

            repository.save(new User(1L,
                    "Mudassir",
                    "mudassir@gmail.com"));

            repository.save(new User(2L,
                    "John",
                    "john@gmail.com"));

            repository.save(new User(3L,
                    "David",
                    "david@gmail.com"));

        };

    }

}

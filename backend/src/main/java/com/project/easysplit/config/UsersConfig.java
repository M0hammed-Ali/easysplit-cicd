package com.project.easysplit.config; // Updated package name to com.project.easysplit.config

import com.project.easysplit.model.Users; // Updated import statement
import com.project.easysplit.repository.UsersRepository; // Updated import statement
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig { // Renamed class to UsersConfig
    @Bean
    CommandLineRunner usersCommandLineRunner(UsersRepository repository) { // Updated method parameter to UsersRepository and method name to userCommandLineRunner
        return args -> {
            if (repository.count() == 0) {
                Users jon = new Users( // Updated object creation to Users
                        "Jon"
                );
                Users snow = new Users( // Updated object creation to Users
                        "Snow"
                );
                Users jim = new Users( // Updated object creation to Users
                        "Jim"
                );

                repository.saveAll( // Updated method call to saveAll()
                        List.of(jon, jim, snow)
                );
            }
        };
    }
}

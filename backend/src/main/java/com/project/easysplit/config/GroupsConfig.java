package com.project.easysplit.config;

import com.project.easysplit.model.Groups;
import com.project.easysplit.repository.GroupsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GroupsConfig {
    @Bean
    CommandLineRunner groupsCommandLineRunner(GroupsRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Groups group1 = new Groups("Group 1");
                Groups group2 = new Groups("Group 2");
                Groups group3 = new Groups("Group 3");

                repository.saveAll(List.of(group1, group2, group3));
            }
        };
    }
}

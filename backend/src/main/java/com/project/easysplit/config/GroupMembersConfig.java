package com.project.easysplit.config;

import com.project.easysplit.model.GroupMembers;
import com.project.easysplit.repository.GroupMembersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupMembersConfig {

    @Bean
    CommandLineRunner groupMembersCommandLineRunner(GroupMembersRepository repository) {
        return args -> {
            // You can add initialization logic here if needed
        };
    }
}

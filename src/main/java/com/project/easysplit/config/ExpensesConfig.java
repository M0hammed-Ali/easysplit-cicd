package com.project.easysplit.config;

import com.project.easysplit.model.Expenses;
import com.project.easysplit.model.Groups;
import com.project.easysplit.model.Users;
import com.project.easysplit.repository.ExpensesRepository;
import com.project.easysplit.repository.GroupMembersRepository;
import com.project.easysplit.repository.GroupsRepository;
import com.project.easysplit.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
public class ExpensesConfig {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @Bean
    CommandLineRunner expensesCommandLineRunner(ExpensesRepository repository) {
        return args -> {
//            if (expensesRepository.count() == 0) {
//                // Fetch users and groups
//                Optional<Users> user1 = usersRepository.findById(1L);
//                Optional<Users> user2 = usersRepository.findById(2L);
//                Optional<Groups> group1 = groupsRepository.findById(1L);
//                Optional<Groups> group2 = groupsRepository.findById(2L);
//
//                // Create sample expenses associated with users and groups
//                Expenses expense1 = new Expenses(new Date(), new BigDecimal("50.00"), "Expense 1", user1, group1);
//                Expenses expense2 = new Expenses(new Date(), new BigDecimal("30.00"), "Expense 2", user2, group1);
//                Expenses expense3 = new Expenses(new Date(), new BigDecimal("20.00"), "Expense 3", user1, group2);
//
//                // Save expenses to the database
//                expensesRepository.saveAll(List.of(expense1, expense2, expense3));
//            }
        };
    }
}

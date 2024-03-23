package com.project.easysplit.service; // Updated package name to com.project.easysplit.service

import com.project.easysplit.model.Users; // Updated import statement
import com.project.easysplit.repository.UsersRepository; // Updated import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService { // Renamed class to UsersService
    private final UsersRepository usersRepository; // Updated variable name to usersRepository

    @Autowired
    public UsersService(UsersRepository usersRepository) { // Renamed constructor to UsersService
        this.usersRepository = usersRepository; // Updated variable name to usersRepository
    }

    public List<Users> getUsers() { // Updated return type to List<Users> and method name to getUsers
        return usersRepository.findAll(); // Updated method call to findAll()
    }

    public void addNewUser(Users user) { // Updated parameter type to Users and method name to addNewUser
        usersRepository.save(user); // Updated method call to save()
    }

    public void deleteUser(Long id) { // Updated parameter type to Long and method name to deleteUser
        boolean exists = usersRepository.existsById(id); // Updated variable name to usersRepository and method call to existsById()
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist"); // Updated exception message
        }
        usersRepository.deleteById(id); // Updated method call to deleteById()
    }
}

package com.project.easysplit.controller; // Updated package name to com.project.easysplit.controller

import com.project.easysplit.model.Users; // Updated import statement
import com.project.easysplit.service.UsersService; // Updated import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/users")
@CrossOrigin
public class UsersController { // Renamed class to UsersController

    private final UsersService usersService; // Renamed variable to usersService

    @Autowired
    public UsersController(UsersService usersService) { // Renamed constructor to UsersController
        this.usersService = usersService; // Renamed variable to usersService
    }

    @GetMapping
    public List<Users> getUsers() { // Updated return type to List<Users> and method name to getUsers
        return usersService.getUsers(); // Updated method call to getUsers()
    }

    @PostMapping
    public void registerNewUser(@RequestBody Users user) { // Updated parameter type to Users and method name to registerNewUser
        usersService.addNewUser(user); // Updated method call to addNewUser()
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) { // Updated parameter type to Long and method name to deleteUser
        usersService.deleteUser(id); // Updated method call to deleteUser()
    }
}

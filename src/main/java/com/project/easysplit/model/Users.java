package com.project.easysplit.model; // Updated package name to com.project.easysplit.model

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Updated table name to "users"
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username") // Mapping to the "username" column
    private String username; // Changed variable name from "name" to "username"

    public Users() {
    }

    public Users(String username) { // Updated constructor parameter name
        this.username = username; // Changed variable name from "name" to "username"
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() { // Updated getter method name
        return username; // Changed variable name from "name" to "username"
    }

    public void setUsername(String username) { // Updated setter method name
        this.username = username; // Changed variable name from "name" to "username"
    }

    public Users(Long id, String username) { // Updated constructor parameter name
        this.id = id;
        this.username = username; // Changed variable name from "name" to "username"
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' + // Changed variable name from "name" to "username"
                '}';
    }
}

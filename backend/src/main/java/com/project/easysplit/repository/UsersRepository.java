package com.project.easysplit.repository; // Updated package name to com.project.easysplit.repository

import com.project.easysplit.model.Users; // Updated import statement
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> { // Renamed interface to UsersRepository
}

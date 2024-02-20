package com.collegemanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameAndPassword(String userName, String password);

	Optional<User> findByUsername(String username);

}

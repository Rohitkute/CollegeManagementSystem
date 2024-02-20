package com.collegemanagementsystem.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegemanagementsystem.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	@Query("select l from Login l where username=:username and password=:password")
	public Optional<Login> getLogin(String username,String password);


}

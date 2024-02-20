package com.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.collegemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.Department;
import com.collegemanagementsystem.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	List<Exam> findAllByDepartment(Department dept);
}

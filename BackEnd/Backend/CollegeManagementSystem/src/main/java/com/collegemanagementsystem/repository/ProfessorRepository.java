package com.collegemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	Optional<Professor> findByFirstName(String professorName);
	Optional<List<Professor>> findAllByDepartmentDepartmentName(String deptName);
}

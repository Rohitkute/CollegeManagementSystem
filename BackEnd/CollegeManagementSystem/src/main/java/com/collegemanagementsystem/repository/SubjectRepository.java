package com.collegemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.Professor;
import com.collegemanagementsystem.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	 List<Subject> findAllByProfessor(Professor prof);
	//Optional<List<Subject>> findAllByProfessorProfessorName(String profName);
	
}

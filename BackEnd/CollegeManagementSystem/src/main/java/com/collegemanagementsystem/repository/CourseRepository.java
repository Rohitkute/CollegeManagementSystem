package com.collegemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findByCourseName(String courseName);
	Optional<List<Course>> findAllByDepartmentDepartmentName(String deptName);
}

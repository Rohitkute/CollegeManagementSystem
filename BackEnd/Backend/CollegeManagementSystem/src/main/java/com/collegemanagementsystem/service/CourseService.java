package com.collegemanagementsystem.service;

import java.util.List;

import com.collegemanagementsystem.dto.CourseDto;


public interface CourseService {
	
	String addCourse(CourseDto courseDto);
	CourseDto getCourseById(Long id);
	List<CourseDto> getAllCoursesByDepartmentName(String deptName);
	List<CourseDto> getAllCourses();
	String updateCourseDetails(CourseDto courseDto,Long id);
	String cancelStudentFromCourse(Long courseId, Long studentId);
	String deleteCourseById(Long id);
}

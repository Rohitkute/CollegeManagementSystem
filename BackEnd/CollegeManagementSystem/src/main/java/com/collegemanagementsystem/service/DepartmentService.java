package com.collegemanagementsystem.service;

import java.util.List;

import com.collegemanagementsystem.dto.DepartmentDto;

public interface DepartmentService {
	String addDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(Long id);
	List<DepartmentDto> getAllDepartments();
	String deleteDepartment(Long id);
	String updateDepartmentDetails(DepartmentDto departmentDto,Long id);
	String cancelCourseFromDepartment(Long deptId, Long courseId);
	String cancelProfessorFromDepartment(Long deptId, Long professorId);
	String cancelExamFromDepartment(Long deptId, Long examId);
}

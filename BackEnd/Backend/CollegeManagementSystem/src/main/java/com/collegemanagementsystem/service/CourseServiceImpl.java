package com.collegemanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.custom_exceptions.ResourceNotFoundException;
import com.collegemanagementsystem.dto.CourseDto;
import com.collegemanagementsystem.entities.Course;
import com.collegemanagementsystem.entities.Department;
import com.collegemanagementsystem.entities.Student;
import com.collegemanagementsystem.repository.CourseRepository;
import com.collegemanagementsystem.repository.DepartmentRepository;
import com.collegemanagementsystem.repository.StudentRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addCourse(CourseDto courseDto) {
		Department department = departmentRepo.findByDepartmentName(courseDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		Course course = mapper.map(courseDto, Course.class);
		Course persistentcourse = courseRepo.save(course);
		department.addCourse(persistentcourse);
		return persistentcourse.getCourseName() + " Course added successfully";
	}
	
	@Override
	public CourseDto getCourseById(Long id) {
		Course course = courseRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		CourseDto courseDto = mapper.map(course, CourseDto.class);
		courseDto.setDepartmentName(course.getDepartment().getDepartmentName());
		return courseDto;
	}
	
	@Override
	public List<CourseDto> getAllCoursesByDepartmentName(String deptName) {
		List<Course> courses = courseRepo.findAllByDepartmentDepartmentName(deptName)
				.orElseThrow(() -> new ResourceNotFoundException("No course found in Department " + deptName));
//		List<CourseDto> courseDtoList = courses.stream().map(course -> this.mapper.map(courses, CourseDto.class)).collect(Collectors.toList());
		List<CourseDto> courseDtoList= new ArrayList<CourseDto>();
		for (Course course : courses) {
			CourseDto courseDto = mapper.map(course,CourseDto.class);
			courseDto.setDepartmentName(deptName);
			courseDtoList.add(courseDto);
		}
		return courseDtoList;
	}
	
	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courseList = courseRepo.findAll();
		List<CourseDto> courseDtoList= new ArrayList<CourseDto>();
		for (Course course : courseList) {
			CourseDto courseDto = mapper.map(course,CourseDto.class);
			courseDto.setDepartmentName(course.getDepartment().getDepartmentName());
			courseDtoList.add(courseDto);
		}
		return courseDtoList;
	}
	
	@Override
	public String updateCourseDetails(CourseDto courseDto, Long id) {
		
		Department department = departmentRepo.findByDepartmentName(courseDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		Course course = courseRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		course.setDepartment(department);
		mapper.map(courseDto, course);
	
		return course.getCourseName()+" successfully updated";
	}
	@Override
	public String cancelStudentFromCourse(Long courseId, Long studentId) {
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Invalid Course ID!!!!!"));
		Student student = studentRepo.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Invalid Student ID!!!!!"));
		course.removeStudent(student);
	    studentRepo.delete(student);
	    courseRepo.save(course);
		return "Deleted student : " + student.getFirstName();
	}

	
	@Override
	public String deleteCourseById(Long id) {
		Course course = courseRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		List<Course> courselist = courseRepo.findAll();
		courselist.remove(course);
		courseRepo.delete(course);
		courseRepo.saveAll(courselist);
		return course.getCourseName()+" was removed";
	}
}

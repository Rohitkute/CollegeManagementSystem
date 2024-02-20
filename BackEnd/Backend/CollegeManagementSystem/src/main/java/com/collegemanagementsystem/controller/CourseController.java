package com.collegemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.dto.ApiResponse;
import com.collegemanagementsystem.dto.CourseDto;
import com.collegemanagementsystem.service.CourseService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody CourseDto courseDto){
		try {
			System.out.println("in add new course "+courseDto);
			return new ResponseEntity<>(new ApiResponse(courseService.addCourse(courseDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/singleCourse/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		try {
			System.out.println("in get course by id ");
			return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/department_Name/{departmentName}")
	public ResponseEntity<?> getAllCourseByDepartmentName(@PathVariable String departmentName) {
		try {

			System.out.println("in get courses by department: "+departmentName);
			return new ResponseEntity<>(courseService.getAllCoursesByDepartmentName(departmentName), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}
	

	@GetMapping("/ListOfCourses")
	public ResponseEntity<?> getAllAvailableCourses() {
		try {
			System.out.println("in get all available courses: ");
			return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}
	
	@PutMapping("/updateCourse/{id}")
	public  ResponseEntity<?>updateCourse(@RequestBody CourseDto course, @PathVariable Long id) {
		try {
			System.out.println("in get course by id ");
			return new ResponseEntity<>( courseService.updateCourseDetails(course, id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@DeleteMapping("/{courseId}/student/{studentId}")
	public ResponseEntity<?> deleteStudentFromCourse(@PathVariable Long courseId,@PathVariable Long studentId){
		try {
			return new ResponseEntity<>(courseService.cancelStudentFromCourse(courseId,studentId),HttpStatus.OK);
		}catch(RuntimeException e){
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteSingleCourse/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable Long id){
		try {
			System.out.println("in delete Course by id ");
			return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
}

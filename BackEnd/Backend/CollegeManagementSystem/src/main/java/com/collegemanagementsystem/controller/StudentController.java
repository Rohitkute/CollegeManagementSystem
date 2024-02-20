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
import com.collegemanagementsystem.dto.StudentDto;
import com.collegemanagementsystem.service.StudentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDto studentDto) {
		try {
			System.out.println("in add student "+ studentDto);
			return new ResponseEntity<>(new ApiResponse(studentService.addStudent(studentDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/singleStudent/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		try {
			System.out.println("in get student by id ");
			return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
			
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/listOfStudents")
	public ResponseEntity<?> getAllStudents() {
		try {
			System.out.println("in getAllStudents");
			return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
			} 
		catch (RuntimeException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
		try {
			System.out.println("in update department by id ");
			return new ResponseEntity<>(studentService.updateStudent(studentDto, id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping("/deleteSingleStudent/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
		try {
			System.out.println("in get department by id ");
			return new ResponseEntity<>(studentService.deleteStudentById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
}

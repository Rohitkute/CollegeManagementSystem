package com.collegemanagementsystem.controller;

import java.util.List;

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
import com.collegemanagementsystem.dto.SubjectDto;
import com.collegemanagementsystem.service.SubjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService; 	
	
	@PostMapping
	public ResponseEntity<?> addSubject(@RequestBody SubjectDto subjectDto){
	          
//		SubjectDto createdSubjectDto =  this.subjectService.addSubject(subjectDto, professorId);
//		return  new ResponseEntity<SubjectDto>(createdSubjectDto,HttpStatus.CREATED);
		try {
			System.out.println("in add new subject" + subjectDto);
			return new ResponseEntity<>(new ApiResponse(subjectService.addSubject(subjectDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/updateSubject/{subjectId}")
	public String updateSubject(@RequestBody SubjectDto subjectDto ,@PathVariable Long subjectId)
	{
//		SubjectDto updateSubject = this.subjectService.updateSubject(subjectDto,subjectId);
//		return new ResponseEntity<SubjectDto>(updateSubject, HttpStatus.OK);
		
		return subjectService.updateSubjectDetails(subjectDto, subjectId);
	}
	
	@DeleteMapping("/deleteSingleSubject/{subjectId}")
	public ResponseEntity<?> deleteSubjectById(@PathVariable Long subjectId )
	{
//		this.subjectService.deleteSubject(subjectId);
//	    return new ApiResponse("Subject is successfully deleted");
		try {
			System.out.println("in delete Subject by id");
			return new ResponseEntity<>(subjectService.deleteSubjectById(subjectId),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/ListOfSubjects")
	public ResponseEntity<?> getAllSubject()
	{
//		List<SubjectDto> allSubject = this.subjectService.getAllSubject();
//		return new ResponseEntity<List<SubjectDto>>(allSubject,HttpStatus.OK);
		try {
			System.out.println("in get all available subjects ");
			return new ResponseEntity<>(subjectService.getAllSubject(),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/subjects/{subjectId}")
	public ResponseEntity<?> getSubjectById(@PathVariable Long subjectId)
	{
//	    SubjectDto subjectDto = this.subjectService.getSubjectById(subjectId);
//		return new ResponseEntity<SubjectDto>(subjectDto,HttpStatus.OK);
		try {
			System.out.println("in get subject by id");
			return new ResponseEntity<>(subjectService.getSubjectById(subjectId),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/professor_Name/{professorName}")
	public ResponseEntity<?> getAllSubjectByProfessorName(@PathVariable String professorName)
	{
      		List<SubjectDto> subjectsDto = this.subjectService.getAllSubjectsByProfessorName(professorName);
	       	
		  return new ResponseEntity<List<SubjectDto>>(subjectsDto,HttpStatus.OK);
	}
	
	
}

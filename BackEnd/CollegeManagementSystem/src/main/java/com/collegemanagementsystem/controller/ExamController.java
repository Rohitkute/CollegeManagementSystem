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
import com.collegemanagementsystem.dto.ExamDto;
import com.collegemanagementsystem.service.ExamService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

	@Autowired
	private ExamService examService; 	
	
	@PostMapping
	public ResponseEntity<?> addExam(@RequestBody ExamDto examDto){
	          
//		SubjectDto createdSubjectDto =  this.subjectService.addSubject(subjectDto, professorId);
//		return  new ResponseEntity<SubjectDto>(createdSubjectDto,HttpStatus.CREATED);
		try {
			System.out.println("in add new exam" + examDto);
			return new ResponseEntity<>(new ApiResponse(examService.addExam(examDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/updateExam/{examId}")
	public String updateExam(@RequestBody ExamDto examDto ,@PathVariable Long examId)
	{
//		SubjectDto updateSubject = this.subjectService.updateSubject(subjectDto,subjectId);
//		return new ResponseEntity<SubjectDto>(updateSubject, HttpStatus.OK);
		
		return examService.updateExamDetails(examDto, examId);
	}
	
	@DeleteMapping("/deleteSingleExam/{examId}")
	public ResponseEntity<?> deleteExamById(@PathVariable Long examId )
	{
//		this.subjectService.deleteSubject(subjectId);
//	    return new ApiResponse("Subject is successfully deleted");
		try {
			System.out.println("in delete Subject by id");
			return new ResponseEntity<>(examService.deleteExamById(examId),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/ListOfExams")
	public ResponseEntity<?> getAllExam()
	{
//		List<SubjectDto> allSubject = this.subjectService.getAllSubject();
//		return new ResponseEntity<List<SubjectDto>>(allSubject,HttpStatus.OK);
		try {
			System.out.println("in get all available exams ");
			return new ResponseEntity<>(examService.getAllExam(),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/exams/{examId}")
	public ResponseEntity<?> getExamById(@PathVariable Long examId)
	{
//	    SubjectDto subjectDto = this.subjectService.getSubjectById(subjectId);
//		return new ResponseEntity<SubjectDto>(subjectDto,HttpStatus.OK);
		try {
			System.out.println("in get exam by id");
			return new ResponseEntity<>(examService.getExamById(examId),HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/department_name/{departmentName}")
	public ResponseEntity<?> getAllExamByDepartmentName(@PathVariable String departmentName)
	{
      	  List<ExamDto> examsDto = this.examService.getAllExamsByDepartmentName(departmentName);
	       	
		  return new ResponseEntity<List<ExamDto>>(examsDto,HttpStatus.OK);
	}
}
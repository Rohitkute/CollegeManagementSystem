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
import com.collegemanagementsystem.dto.ProfessorDto;
import com.collegemanagementsystem.service.ProfessorService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/professors")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<?> addNewProfessor(@RequestBody ProfessorDto professorDto){
		try {
			System.out.println("in add new Professor "+ professorDto);
			return new ResponseEntity<>(new ApiResponse(professorService.addProfessor(professorDto)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/singleProfessor/{id}")
	public ResponseEntity<?> getProfessorById(@PathVariable Long id) {
		try {
			System.out.println("in get Professor by id ");
			return new ResponseEntity<>(professorService.getProfessorById(id), HttpStatus.OK);
			}
			catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
	@GetMapping("/professorsBydepartmentName/{departmentName}")
	public ResponseEntity<?> getAllProfessorsByDepartmentName(@PathVariable String departmentName) {
		try {
			System.out.println("in get professors by department: "+departmentName);
			return new ResponseEntity<>(professorService.getAllProfessorByDepartmentName(departmentName), HttpStatus.OK);
			} 
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
	@GetMapping("/ListOfProfessors")
	public ResponseEntity<?> getAllAvailableProfessors() {
		try {
			System.out.println("in get all available Professors ");
			return new ResponseEntity<>(professorService.getAllProfessors(), HttpStatus.OK);
			} 
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
	@PutMapping("/updateProfessor/{id}")
	public ResponseEntity<?> updateProfessor(@RequestBody ProfessorDto professor, @PathVariable Long id) {
		try {
			System.out.println("in update Professor ");
			return new ResponseEntity<>(professorService.updateProfessorDetails(professor, id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
	
	@DeleteMapping("/deleteSingleProfessor/{id}")
	public ResponseEntity<?> deleteProfessorById(@PathVariable Long id){
		try {
			System.out.println("in delete Professor by id ");
			return new ResponseEntity<>(professorService.deleteProfessorById(id), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}

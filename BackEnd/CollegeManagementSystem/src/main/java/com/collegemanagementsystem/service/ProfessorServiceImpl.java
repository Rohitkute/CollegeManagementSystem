package com.collegemanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.custom_exceptions.ResourceNotFoundException;
import com.collegemanagementsystem.dto.ProfessorDto;
import com.collegemanagementsystem.entities.Department;
import com.collegemanagementsystem.entities.Professor;
import com.collegemanagementsystem.repository.DepartmentRepository;
import com.collegemanagementsystem.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addProfessor(ProfessorDto professorDto) {
		Department department = departmentRepo.findByDepartmentName(professorDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		Professor professor = mapper.map(professorDto, Professor.class);
		Professor persistentProfessor = professorRepo.save(professor);
		department.addProfessor(persistentProfessor);
		return "Professor: "+persistentProfessor.getFirstName()+" "+persistentProfessor.getLastName()+ " added successfully";
	}
	
	@Override
	public ProfessorDto getProfessorById(Long id) {
		Professor professor = professorRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		ProfessorDto professorDto = mapper.map(professor, ProfessorDto.class);
		professorDto.setDepartmentName(professor.getDepartment().getDepartmentName());
		return professorDto;
	}
	
	@Override
	public List<ProfessorDto> getAllProfessorByDepartmentName(String deptName) {
		List<Professor> professorList = professorRepo.findAllByDepartmentDepartmentName(deptName)
				.orElseThrow(() -> new ResourceNotFoundException("No course found in Department " + deptName));
//		List<CourseDto> courseDtoList = courses.stream().map(course -> this.mapper.map(courses, CourseDto.class)).collect(Collectors.toList());
		List<ProfessorDto> professorDtoList= new ArrayList<ProfessorDto>();
		for (Professor professor : professorList) {
			ProfessorDto professorDto = mapper.map(professor,ProfessorDto.class);
			professorDto.setDepartmentName(deptName);
			professorDtoList.add(professorDto);
		}
		return professorDtoList;
	}
	
	@Override
	public List<ProfessorDto> getAllProfessors() {
		List<Professor> professorList = professorRepo.findAll();
		List<ProfessorDto> professorDtoList = new ArrayList<ProfessorDto>();
		for (Professor professor : professorList) {
			ProfessorDto professorDto = mapper.map(professor,ProfessorDto.class);
//			studentDto.setAddressPincode(student.getAddress().getPincode());
			professorDto.setDepartmentName(professor.getDepartment().getDepartmentName());
			professorDtoList.add(professorDto);
		}
		return professorDtoList;
	}
	
	@Override
	public String updateProfessorDetails(ProfessorDto professorDto, Long id) {
		Professor professor = professorRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));	
		Department department = departmentRepo.findByDepartmentName(professorDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		professor.setDepartment(department);
		mapper.map(professorDto, professor);
		return professor.getFirstName()+" "+professor.getLastName()+" successfully updated";
	}
	
	@Override
	public String deleteProfessorById(Long id) {
		Professor professor = professorRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		List<Professor> professorList = professorRepo.findAll();
		professorList.remove(professor);
		professorRepo.delete(professor);
		professorRepo.saveAll(professorList);
		return professor.getFirstName()+" "+professor.getLastName()+" was removed";
	}
}

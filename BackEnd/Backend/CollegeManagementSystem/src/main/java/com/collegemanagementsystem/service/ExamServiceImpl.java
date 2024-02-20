package com.collegemanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.custom_exceptions.ResourceNotFoundException;
import com.collegemanagementsystem.dto.ExamDto;
import com.collegemanagementsystem.entities.Department;
import com.collegemanagementsystem.entities.Exam;
import com.collegemanagementsystem.repository.DepartmentRepository;
import com.collegemanagementsystem.repository.ExamRepository;

@Service
@Transactional
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamRepository examRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public String addExam(ExamDto examDto) {
		// TODO Auto-generated method stub
		//return null;
        Department dept = this.deptRepo.findByDepartmentName(examDto.getDepartmentName()).orElseThrow(() -> new ResourceNotFoundException("Department Id is not found"));
		
		Exam exam = this.modelMapper.map(examDto,Exam.class);
	
		Exam newExam = this.examRepo.save(exam);
		
	    dept.addExam(newExam);
		return newExam.getExamName()+" exam added successfully";
	}
	
	@Override
	public String updateExamDetails(ExamDto examDto, Long examId) {
		// TODO Auto-generated method stub
		Exam exam = examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		Department dept = this.deptRepo.findByDepartmentName(examDto.getDepartmentName()).orElseThrow(() -> new ResourceNotFoundException("department name was not found"));
		exam.setDepartment(dept);
		this.examRepo.save(exam);
		modelMapper.map(examDto, exam);
		
		
 		return exam.getExamName() +" successfully Updated";

	}
	
	@Override
	public String deleteExamById(Long examId) {
		// TODO Auto-generated method stub
		//return null;
        Exam exam = this.examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("exam Id was not found"));
		
		List<Exam> examList = examRepo.findAll();
		examList.remove(exam);
		examRepo.delete(exam);
		examRepo.saveAll(examList);
		return exam.getExamName()+" was removed";
		
		//this.subRepo.delete(sub);

	}
	
	@Override
	public List<ExamDto> getAllExam() {
		// TODO Auto-generated method stub
		//return null;
		List<Exam> allExams = this.examRepo.findAll();
		//List<SubjectDto> subDtos = allSubjects.stream().map((subject) -> this.modelMapper.map(subject, SubjectDto.class)).collect(Collectors.toList());
		List<ExamDto> examDtoList = new ArrayList<ExamDto>();
		for(Exam exam : allExams) {
			ExamDto examDto = modelMapper.map(exam,ExamDto.class);
			examDto.setDepartmentName(exam.getDepartment().getDepartmentName());
			examDtoList.add(examDto);
		}
		return examDtoList;

		
	}
	
	@Override
	public ExamDto getExamById(Long examId) {
		// TODO Auto-generated method stub
		//return null;
		Exam exam = this.examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("Exam Id was not found"));
		// TODO Auto-generated method stub
		//return null;
		ExamDto examDto = modelMapper.map(exam,ExamDto.class);
		examDto.setDepartmentName(exam.getDepartment().getDepartmentName());
		return examDto;

	}
	
	@Override
	public List<ExamDto> getAllExamsByDepartmentName(String deptName) {
		// TODO Auto-generated method stub
		//return null;
		Department dept = this.deptRepo.findByDepartmentName(deptName).orElseThrow(() -> new ResourceNotFoundException("department name was not found"));
    	List<Exam> exams = this.examRepo.findAllByDepartment(dept);
    	
    	//List<SubjectDto> subjectDtos = subjects.stream().map((subject) -> this.modelMapper.map(subject,SubjectDto.class)).collect(Collectors.toList());
    	List<ExamDto> examDtoList= new ArrayList<ExamDto>();
		for (Exam exam : exams) {
			ExamDto examDto = modelMapper.map(exam,ExamDto.class);
			examDto.setDepartmentName(deptName);
			examDtoList.add(examDto);
		}
		return examDtoList;
	}       
	
	
}
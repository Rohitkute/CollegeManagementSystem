package com.collegemanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.custom_exceptions.ResourceNotFoundException;
import com.collegemanagementsystem.dto.SubjectDto;
import com.collegemanagementsystem.entities.Professor;
import com.collegemanagementsystem.entities.Subject;
import com.collegemanagementsystem.repository.ProfessorRepository;
import com.collegemanagementsystem.repository.SubjectRepository;
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository subRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProfessorRepository profRepo;


	@Override
	public String addSubject(SubjectDto subjectDto) {
		// TODO Auto-generated method stub
        Professor prof = this.profRepo.findByFirstName(subjectDto.getProfessorName()).orElseThrow(() -> new ResourceNotFoundException("professor Id is not found"));
		
		Subject sub = this.modelMapper.map(subjectDto,Subject.class);
		
		Subject newSubject = this.subRepo.save(sub);
		
	    prof.addsubject(newSubject);
		return newSubject.getSubjectName()+"subject added successfully";
	}
	
	@Override
	public String updateSubjectDetails(SubjectDto subjectDto, Long subjectId) {
		
		Subject subject = subRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		Professor prof = this.profRepo.findByFirstName(subjectDto.getProfessorName()).orElseThrow(() -> new ResourceNotFoundException("professor name was not found"));
		subject.setProfessor(prof);
		this.subRepo.save(subject);
		modelMapper.map(subjectDto, subject);
		
		
 		return subject.getSubjectName()+"successfully Updated";
		
		
	}
	
	@Override
	public String deleteSubjectById(Long subjectId) {
		// TODO Auto-generated method stub
		Subject sub = this.subRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("subject Id was not found"));
		
		List<Subject> subjectList = subRepo.findAll();
		subjectList.remove(sub);
		subRepo.delete(sub);
		subRepo.saveAll(subjectList);
		return sub.getSubjectName()+" was removed";
		
		//this.subRepo.delete(sub);
	}
	
	@Override
	public List<SubjectDto> getAllSubject() {
		// TODO Auto-generated method stub
		//return null;
		List<Subject> allSubjects = this.subRepo.findAll();
		//List<SubjectDto> subDtos = allSubjects.stream().map((subject) -> this.modelMapper.map(subject, SubjectDto.class)).collect(Collectors.toList());
		List<SubjectDto> subjectDtoList = new ArrayList<SubjectDto>();
		for(Subject subject : allSubjects) {
			SubjectDto subjectDto = modelMapper.map(subject,SubjectDto.class);
			subjectDto.setProfessorName(subject.getProfessor().getFirstName());
			subjectDtoList.add(subjectDto);
		}
		return subjectDtoList;
	}
	
	@Override
	public SubjectDto getSubjectById(Long subjectId) {
		// TODO Auto-generated method stub
		//return null;
		Subject sub = this.subRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject Id was not found"));
		// TODO Auto-generated method stub
		//return null;
		SubjectDto subjectDto = modelMapper.map(sub,SubjectDto.class);
		subjectDto.setProfessorName(sub.getProfessor().getFirstName());
		return subjectDto;

	}
	
	 @Override
	    public List<SubjectDto> getAllSubjectsByProfessorName(String profName) {
	    	Professor prof = this.profRepo.findByFirstName(profName).orElseThrow(() -> new ResourceNotFoundException("professor name was not found"));
	    	List<Subject> subjects = this.subRepo.findAllByProfessor(prof);
	    	
	    	//List<SubjectDto> subjectDtos = subjects.stream().map((subject) -> this.modelMapper.map(subject,SubjectDto.class)).collect(Collectors.toList());
	    	List<SubjectDto> subjectDtoList= new ArrayList<SubjectDto>();
			for (Subject subject : subjects) {
				SubjectDto subjectDto = modelMapper.map(subject,SubjectDto.class);
				subjectDto.setProfessorName(profName);
				subjectDtoList.add(subjectDto);
			}
			return subjectDtoList;
	    	//return subjectDtos;
	    	
	 	}
}

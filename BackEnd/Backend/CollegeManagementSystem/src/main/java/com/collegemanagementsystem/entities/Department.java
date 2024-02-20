package com.collegemanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	@Column(length = 30,unique = true)
	private String departmentName;
	@Column(length = 10)
	private String phoneNo;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Professor> professors = new ArrayList<Professor>();
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Course> courses = new ArrayList<Course>();
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Exam> exams = new ArrayList<Exam>();

	//helper methods 	
	public void addProfessor(Professor p) {
		professors.add(p);// dept --> prof
		p.setDepartment(this);// prof --> dept
	}

	public void removeProfessor(Professor p) {
		professors.remove(p);//dept --> prof
		p.setDepartment(null);//prof --> dept
	}
	
	public void addCourse(Course c) {
		courses.add(c);
		c.setDepartment(this);
	}

	public void removeCourse(Course c) {
		courses.remove(c);
		c.setDepartment(null);
	}
	
	public void addExam(Exam e) {
		exams.add(e);
		e.setDepartment(this);
	}

	public void removeExam(Exam e) {
		exams.remove(e);
		e.setDepartment(null);
	}

}

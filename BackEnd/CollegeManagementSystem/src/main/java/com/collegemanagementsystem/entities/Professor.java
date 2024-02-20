package com.collegemanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professor_id;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 10)
	private String gender;
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 30)
	private String password;
	@Transient
	private String confirmPassword;
	

	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
	private Department department;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Subject> subjects = new ArrayList<Subject>();

	
	//helper methods
	public void addStudent(Student s) {
		students.add(s);
		s.setProfessor(this);
	}

	public void removeStudent(Student s) {
		students.remove(s);
		s.setProfessor(null);
	}
	
	public void addsubject(Subject s) {
		subjects.add(s);
		s.setProfessor(this);
	}
	
	public void removeSubject(Subject s) {
		subjects.remove(s);
		s.setProfessor(null);
	}
	
}

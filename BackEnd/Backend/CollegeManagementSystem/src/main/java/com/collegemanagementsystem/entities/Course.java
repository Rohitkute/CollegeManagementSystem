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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	@Column(length = 30,unique = true)
	private String courseName;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name="department_id")
	private Department department;
	
	//helper methods
	public void addStudent(Student s) {
		students.add(s);
		s.setCourse(this);
	}

	public void removeStudent(Student s) {
		students.remove(s);
		s.setCourse(null);
	}
}

package com.collegemanagementsystem.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 20)
	private LocalDate dob;
	@Column(length = 10)
	private String gender;
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 30)
	private String password;
	@Transient
	private String confirmPassword;
	@Column
	private String address;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name= "professor_id")
	private Professor professor;
	
}

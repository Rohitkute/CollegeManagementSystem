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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examId;
	@Column(length = 10)
	private LocalDate examDate;
	@Column(length = 30)
	private String examName;
	@Column(length = 20)
	private String examVenue;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name="department_id")
	private Department department;

}

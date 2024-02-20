package com.collegemanagementsystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
	
	private Long examId;
	
	private LocalDate examDate;
	
	private String examName;
	
	private String email;
	
	private String examVenue;
	
	private String departmentName;
}

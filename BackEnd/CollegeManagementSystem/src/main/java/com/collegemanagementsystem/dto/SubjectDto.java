package com.collegemanagementsystem.dto;

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
public class SubjectDto {

		
		private Long subjectId;
		
		private String subjectName;
		
		private String subjectDescription;
		
		private String professorName;
	}




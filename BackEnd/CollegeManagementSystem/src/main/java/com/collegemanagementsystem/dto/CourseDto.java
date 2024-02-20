package com.collegemanagementsystem.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CourseDto {

	private Long courseId;
	private String courseName;
	private String description;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String departmentName;
	
}


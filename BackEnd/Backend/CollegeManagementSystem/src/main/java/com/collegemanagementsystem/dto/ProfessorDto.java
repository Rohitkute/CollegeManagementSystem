package com.collegemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfessorDto {
	
	private Long professor_id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	
	@JsonIgnore
	private String confirmPassword;
	
	private String address;
	private String departmentName;
}

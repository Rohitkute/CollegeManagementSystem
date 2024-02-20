package com.collegemanagementsystem.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class StudentDto {

	private Long studentId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String email;	
	
//	@JsonProperty(access = Access.WRITE_ONLY)// this property is going to be used ONLY during un marshalling(de ser.) to
											 // read the course title from the request payload. But it's not required
											 // in resp data
	private String password;
	@JsonIgnore
	private String confirmPassword;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@JsonIgnore
	private String address;
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String courseName;
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String professorName;
}

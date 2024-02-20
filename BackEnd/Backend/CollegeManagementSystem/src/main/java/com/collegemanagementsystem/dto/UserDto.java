package com.collegemanagementsystem.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
public class UserDto {

	@NotBlank
	private String name;
	
	@NotBlank
	private String username;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%]).*")
	private String password;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String contact;
}

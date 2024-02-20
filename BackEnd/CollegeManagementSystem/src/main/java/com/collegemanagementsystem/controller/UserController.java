package com.collegemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.dto.ApiResponse;
import com.collegemanagementsystem.dto.LoginDto;
import com.collegemanagementsystem.dto.UserDto;
import com.collegemanagementsystem.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {  
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
		try {
			System.out.println("in add new user" + userDto);
			return new ResponseEntity<>(new ApiResponse(userService.signUp(userDto)),HttpStatus.CREATED);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}
	
	 @PostMapping("/login")
	   public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		    try {
			System.out.println("in login by username and password");
			if(userService.login(loginDto.getUsername(), loginDto.getPassword())!=null) {
				return new ResponseEntity<>(userService.login(loginDto.getUsername(), loginDto.getPassword()),HttpStatus.OK);
				
			}
			else {
			//return new ResponseEntity<>(userService.login(username,password),HttpStatus.OK);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("unable to find the user"));
			}
		}
	 	catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		

	}
	
  
}
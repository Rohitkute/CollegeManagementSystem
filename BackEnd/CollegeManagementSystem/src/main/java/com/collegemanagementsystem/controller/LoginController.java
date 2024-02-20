package com.collegemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.entities.Login;
import com.collegemanagementsystem.entities.LoginChek;
import com.collegemanagementsystem.service.LoginService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	@Autowired
	LoginService lservice;
	
	@PostMapping("/chkLogin")
	public Login chkLogin(@RequestBody LoginChek lcheck)
	{
		System.out.println(lcheck);
		return lservice.getLogin(lcheck.getUsername(), lcheck.getPassword());
	}

}

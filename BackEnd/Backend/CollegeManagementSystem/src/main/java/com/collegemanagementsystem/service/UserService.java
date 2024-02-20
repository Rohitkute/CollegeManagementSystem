package com.collegemanagementsystem.service;

import com.collegemanagementsystem.dto.UserDto;

public interface UserService {

    String signUp(UserDto userDto);
	
	String login(String username, String password);
}

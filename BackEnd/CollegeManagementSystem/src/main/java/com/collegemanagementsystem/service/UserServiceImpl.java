package com.collegemanagementsystem.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.custom_exceptions.ResourceNotFoundException;
import com.collegemanagementsystem.dto.UserDto;
import com.collegemanagementsystem.entities.User;
import com.collegemanagementsystem.repository.UserRepository;

@Service
@Controller
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	// Without Password Encryption
//	@Override
//	public String signUp(UserDto userDto) {
//		User persistentUser = modelMapper.map(userDto,User.class);
//		userRepo.save(persistentUser);			
//		return persistentUser.getUsername()+" user added successfully";
//	}
	
	// With Password Encryption
	@Override
	public String signUp(UserDto userDto) {
		 
          User user = this.modelMapper.map(userDto,User.class);
          BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
          String encryptedPassword=bcrypt.encode(userDto.getPassword());
          user.setPassword(encryptedPassword);
     
        	User newUser = this.userRepo.save(user);
    		return newUser.getUsername()+" user added successfully";
	}
	
	// Without Password Encryption
//	@Override
//	public String login(String username,String password) {
//
//		User dbuser = userRepo.findByUsernameAndPassword(username,password).orElseThrow(() -> new ResourceNotFoundException("invalid username or password"));
//		UserDto userDto = modelMapper.map(dbuser,UserDto.class);
//		return userDto.getUsername()+" loggoed in successfully";
//	}
//}
	
	// With Password Encryption
	@Override
	public String login(String username,String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		User dbuser = userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user was not found"));
		
		 if(bcrypt.matches(password,dbuser.getPassword()))
		{
			UserDto userDto = modelMapper.map(dbuser,UserDto.class);
			return userDto.getUsername();
		}
		else
		{
			return null;
		}
	}
}

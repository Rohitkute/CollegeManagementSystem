package com.collegemanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.entities.Login;
import com.collegemanagementsystem.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository lrepo;
	
	public Login getLogin(String username,String password)
	{
		Login l;
		Optional<Login>ol=lrepo.getLogin(username, password);
		try
		{
			l=ol.get();		
		}
		catch (Exception e) {
			l=null;
		}
		return l;
	}

}

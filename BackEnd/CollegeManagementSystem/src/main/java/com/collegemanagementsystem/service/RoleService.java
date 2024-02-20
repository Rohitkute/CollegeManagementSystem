package com.collegemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagementsystem.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository rrepo;

}

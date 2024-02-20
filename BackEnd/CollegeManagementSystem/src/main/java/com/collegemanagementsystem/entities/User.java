package com.collegemanagementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.context.annotation.Role;

//import com.collegeduniya.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(length = 20)
    private String name;
	
	@Column(length = 20,unique = true)
	private String username;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 100,unique=true)
	private String password;
	
	@Column(length = 100)
	private String address;
	
	@Column(length = 10,unique=true)
    private String contact;
	
}

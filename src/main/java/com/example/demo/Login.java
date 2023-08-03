package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Login {
	@Id
	private String emailid;
	private String password;
	
	@Column(name = "typeofuser")
	private String typeOfUser;
	
}

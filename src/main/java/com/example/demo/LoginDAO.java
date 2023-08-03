package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginDAO {

	@Autowired
	LoginRepo loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) 
					{								
						if(login.getTypeOfUser().equals(ll.getTypeOfUser())) 
						{
							if(login.getTypeOfUser().equals("admin"))
							{
								return "Admin sucessfully login";
							}
							else
							{
								return "User successfully login";
							}
						}
						else 
						{
							return "Invalid Credentials! Try Again!";
						}					
					}
					else
					{
						return "Invalid Password! Try Again!";
					}
		}
		else
		{
			return "Invalid EmailId! Try Again!";
		}		
	}
	
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) 
		{
				return "User already exist with the given emailid.";
		}
		else
		{
			if(login.getTypeOfUser().equals("admin"))
			{
				loginRepository.save(login);
				return "Account created successfully";
			}
			else if(login.getTypeOfUser().equals("user"))
			{
				loginRepository.save(login);
				return "Account created successfully";
			}
			else
			{
				return "Account creation unsuccessful";
			}
		}
	}
}
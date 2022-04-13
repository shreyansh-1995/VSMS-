package com.app.service;

//import java.util.Optional;

//import com.app.dto.EmailAndPasswordDto;
//import com.app.dto.GetEmailDto;
import com.app.pojos.User;

public interface IUserService {
	
	//User authenticateUser(String email, String pwd);

	User authenticateUser(String email, String pwd);
	
	User createNewCustomer(User user);
	
	User createNewAdmin(User user);
	
	User createNewServiceAdvisor(User user);
	
	User createNewMechanic(User user);

	String changePassword(String email, String changePassword);
	//User changePassword(String email, String changePassword);

	

	User findByEmail(String email);
}

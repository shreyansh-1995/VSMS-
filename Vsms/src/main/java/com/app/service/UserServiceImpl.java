package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepo;
import com.app.dto.GetEmailDto;
import com.app.pojos.Roles;
import com.app.pojos.User;

@Service 
@Transactional 
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
//	@Override
//	public EmailAndPasswordDto authenticateUser(String email, String pwd) {
//	System.out.println("in authenticateUser");
//		return userRepo.findByEmailAndPassword(email, pwd);
//	}
	
	
	@Override
	public User authenticateUser(String email, String pwd) {
	//	Optional<User> user = Optional.ofNullable(userRepo.findByEmailAndPassword(email, pwd)).
		User user = userRepo.findByEmail(email);// updated code 27feb (swapnil sir)
		if(user!=null && user.getPassword().equals(pwd))
				return user;
		return  null; //add exception
	}
	
	@Override
	public User createNewCustomer(User user) {
		System.out.println("in createNewCustomer");
		user.setRole(Roles.CUSTOMER);
		user.setActive(true);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	

	@Override
	public User createNewAdmin(User user) {
		System.out.println("in createNewAdmin ");
		user.setRole(Roles.ADMIN);
		user.setActive(true);//0x01
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	@Override
	public User createNewServiceAdvisor(User user) {
		System.out.println("in createNewServiceAdvisor ");
		user.setRole(Roles.SERVICEADVISOR);
		user.setActive(true);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}
	
	@Override
	public User createNewMechanic(User user) {
		System.out.println("in createNewMechanic");
		user.setRole(Roles.MECHANIC);
		user.setActive(false);
		System.out.println("cust " + user.toString());
		return userRepo.save(user);
	}


	@Override
	public String changePassword(String email, String changePassword) {
		System.out.println("in changePassword");
		User user=userRepo.findByEmail(email);//fetch full user detail by email
		user.setPassword(changePassword);
		userRepo.save(user);
		return "Password is changed Successfully";
	}
	
//new method yha add hua hai.... 
	@Override
	public User findByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}
}

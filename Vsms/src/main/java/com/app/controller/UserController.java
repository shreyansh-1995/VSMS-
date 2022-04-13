package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.dto.EmailAndPasswordDto;
//import com.app.dto.GetEmailDto;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private IUserService userService;

//	@PostMapping("/login")
//	public ResponseEntity<?> authenticateUser(@RequestBody EmailAndPasswordDto login) {
//		System.out.println("in authenticateUserC ");
//		User user = userService.authenticateUser(login.getEmail(), login.getPassword());
//		if (user != null) {
//			return new ResponseEntity<>(user, HttpStatus.OK);
//		}
//		return new ResponseEntity<>("No User Found With this credentials", HttpStatus.NO_CONTENT);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid User login) {
		System.out.println("in authenticateUserC ");
		 User user = userService.authenticateUser(login.getEmail(), login.getPassword());///user entity me store krna hai dto me nahi
		return new ResponseEntity<>(user, HttpStatus.OK);
	}	

	@PostMapping("/customerregister")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid User user) {
		System.out.println("in addCustomerC");
		User temp = userService.createNewCustomer(user);

		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}

	@PostMapping("/adminregister")
	public ResponseEntity<?> addAdmin(@RequestBody @Valid  User user) {
		System.out.println("in addAdminC");
		User admin = userService.createNewAdmin(user);

		return new ResponseEntity<>(admin, HttpStatus.CREATED);
	}

	@PostMapping("/serviceregister")
	public ResponseEntity<?> addServiceAdvisor(@RequestBody @Valid User user) {
		System.out.println("in addServiceAdvisorC");
		User servAdv = userService.createNewServiceAdvisor(user);
		return new ResponseEntity<>(servAdv, HttpStatus.CREATED);
	}

	@PostMapping("/mechanicregister")
	public ResponseEntity<?> addMechanic(@RequestBody @Valid User user) {
		System.out.println("in addMechanic");
		User mech = userService.createNewMechanic(user);
		return new ResponseEntity<>(mech, HttpStatus.CREATED);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody @Valid User details) {
		System.out.println("in changePasswordC");
		String message = userService.changePassword(details.getEmail(), details.getPassword());
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	@GetMapping("/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email")String email){
		User user = userService.findByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}

}

package com.app.controller;

import java.util.List;

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

import com.app.dto.EnquiryResponseDto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	IAdminService admin;

	// request to get List of service advisor

	@GetMapping("/fetchserviceadvisor")
	public ResponseEntity<?> fetchServiceAdvisor() {
		System.out.println("in fetchServiceAdvisorC");
		List<ResponseUserDto> serviceAdvisors = admin.fetchAllServiceAdvisor();
		return new ResponseEntity<>(serviceAdvisors, HttpStatus.OK);
	}

	@GetMapping("/fetchcustomers")
	public ResponseEntity<?> fetchcustomers() {
		System.out.println("in fetchcustomersC");
		List<ResponseUserDto> names = admin.fetchAllCustomers();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	@GetMapping("/fetchmechanics")
	public ResponseEntity<?> fetchmechanic() {
		System.out.println("in fetchmechanicC");
		List<ResponseUserDto> names = admin.fetchAllMechanic();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	// Request to get all inactive mechanic list
	@GetMapping("/pendingapproval")
	public ResponseEntity<?> pendingApproval() {
		System.out.println("in pendingApprovalC");
		List<ResponseUserDto> names = admin.fetchPendingApproval();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	// request to approve mechanic by id
	@PostMapping("/updatemechanicstatus/{id}")
	public ResponseEntity<?> updateMechanic(@PathVariable int id)

	{
		System.out.println("in updateMechanicC");
		String message = admin.updateMechanic(id);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	// request to show all active customer enquiry
	@GetMapping("/getcustomerenquiry")
	public ResponseEntity<?> getCustomerEnquiry() {
		System.out.println("in getCustomerEnquiryC ");
		List<CustomerEnquiry> customer = admin.getCustomerEnquiry();
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	// request to set response for customer enquiry
	@PostMapping("/setenquiryresponse")
	public ResponseEntity<?> setEnquiryResponse(@RequestBody EnquiryResponseDto response) {
		System.out.println("in setEnquiryResponseC");
		String message = admin.setEnquiryResponse(response);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// request to show allactive customer service requests
	@GetMapping("/getservicerequest")
	public ResponseEntity<?> getCustomerRequest() {
		System.out.println("in getCustomerRequestC");
		List<ServiceRequest> requests = admin.getCustomerRequest();
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}

	// request to set response for Service Request
	@PostMapping("/setserviceresponse")
	public ResponseEntity<?> setEnquiryResponse(@RequestBody ServiceRequest response) {
		System.out.println("in setEnquiryResponseC");
		String message = admin.setServiceResponse(response);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	// Request to count all Mechanic
	@GetMapping("/countmechanic")
	public ResponseEntity<?> getAllMechanicCount() {
		System.out.println("in getAllMechanicCountC");
		int count = admin.getAllMechanicCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// Request to count all ServiceAdvisors
	@GetMapping("/countserviceadvisor")
	public ResponseEntity<?> getAllServiceAdvisorCount() {
		System.out.println("in getAllServiceAdvisorCountC");
		int count = admin.getAllServiceAdvisorCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// Request to count all customers
	@GetMapping("/countcustomer")
	public ResponseEntity<?> getAllCustomerCount() {
		System.out.println("in getAllCustomerCountC");
		int count = admin.getAllCustomerCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// Request to count all enquiries
	@GetMapping("/countenquiry")
	public ResponseEntity<?> getAllEnquiry() {
		System.out.println("in getAllEnquiryC");
		long count = admin.getAllEnquiry();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}

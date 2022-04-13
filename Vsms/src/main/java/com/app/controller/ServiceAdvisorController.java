package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.JobCard;
import com.app.service.IServiceAdvisorService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceAdvisorController {
	
	@Autowired
	IServiceAdvisorService advisor;
	
	
	//Request to  add new Job card
	@PostMapping("/add")
	public ResponseEntity<?> addJobCard(@RequestBody JobCard card)
	{
		System.out.println("in addJobCardC");
		String message = advisor.addJob(card);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	  
	//Fetch all mechanic name whose active status is true
	@GetMapping("/fetchmechanic")
	public ResponseEntity<?> fetchMechanic()
	{
		System.out.println("in fetchMechanicC ");
		List<String> names = advisor.fetchMechanicName();
		return new ResponseEntity<>(names, HttpStatus.OK);
	}
	
	
	//Request to fetch last 10 jobs Done
	@GetMapping("/fetchrecentjobs")
	public ResponseEntity<?> fetchRecentJobCards()
	{
		System.out.println("in fetchRecentJobCardsC");
		List<JobCard> jobs = advisor.fetchRecentJobCards();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
	// Request to count all JobCards
		@GetMapping("/counttotaljobs")
		public ResponseEntity<?> getAllJobs() {
			System.out.println("in getAllJobsC");
			long count = advisor.getAllJobs();
			return new ResponseEntity<>(count, HttpStatus.OK);
		}
	
}

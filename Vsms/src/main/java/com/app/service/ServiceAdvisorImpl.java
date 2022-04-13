package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dao.JobCardRepo;
import com.app.dao.UserRepo;
import com.app.pojos.JobCard;
import com.app.pojos.Roles;

@Service
@Transactional
public class ServiceAdvisorImpl implements IServiceAdvisorService {

	
	@Autowired
	JobCardRepo repo;	// For accessing jobCards
	
	@Autowired
	UserRepo userRepo;  //for accessing user's table
	
	
	@Override
	public String addJob(JobCard card) {
		System.out.println("in addJob ");
	      card.setActive(true);
	     // repo.save(card);
	     // repo.findAll(List<JobCard>)
	      repo.save(card);
	    
	      // both saveorupdate
	      return "Job card added successfully";
		
	}

	@Override
	public List<String> fetchMechanicName() {
		System.out.println("in fetchMechanicName");
		return userRepo.fetchMechanicName(Roles.MECHANIC);
		
	}

	@Override
	public List<JobCard> fetchRecentJobCards() {
		System.out.println("in fetchRecentJobCards");
		return repo.fetchRecentjobCards();
		
	}

	@Override
	public long getAllJobs() {
		System.out.println("in getAllJobs");
		return repo.count();
	}
	

	

      
      
}

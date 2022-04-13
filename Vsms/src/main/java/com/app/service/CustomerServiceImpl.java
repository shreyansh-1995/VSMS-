package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerEnquiryRepo;
import com.app.dao.JobCardRepo;
import com.app.dao.ServiceRequestRepo;
import com.app.dao.UserRepo;
import com.app.dto.PreviousServiceDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.JobCard;
import com.app.pojos.ServiceRequest;
import com.app.pojos.User;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerEnquiryRepo custEnqRepo;

	@Autowired
	JobCardRepo jobRepo;
	
	@Autowired
	ServiceRequestRepo serviceRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public String addnewEnquiry(CustomerEnquiry enquiry) {
		System.out.println("in add new Enquiry" );
		enquiry.setActive(true);
		custEnqRepo.save(enquiry);
		return "Enquiry Successfully Submitted";
	}

	@Override
	public List<CustomerEnquiry> findAllEnquiries(int custId) {
		System.out.println("in findAllEnquiries");
		return custEnqRepo.findAllBycustId(custId);
	}

	@Override
	public List<PreviousServiceDto> getPreviousRecord(String email) {
		System.out.println("in getPreviousRecord");
		List<JobCard> cards= jobRepo.findAllBycustomerEmail(email);
		List<PreviousServiceDto> dtoList=new ArrayList<>();
	
		for (JobCard c : cards) {
			PreviousServiceDto dto =new PreviousServiceDto();
			//copyProperties(Object source, Object target)
			BeanUtils.copyProperties(c, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@Override
	public String addRequest(ServiceRequest request) {
		System.out.println("in addRequest");
		request.setIsactive(true);
		serviceRepo.save(request);
		return "Request added successfully";
	}

	@Override
	public List<ServiceRequest> showPreviousRequest(int custId) {
		System.out.println("in showPreviousRequest");
		List<ServiceRequest> list =serviceRepo.findAllBycustId(custId);
		return list;
	}

	@Override
	public int countOfNewRequest(int custId) {
		System.out.println("in countOfNewRequest");
		return serviceRepo.countBycustId(custId);	
	}

	@Override
	public int countOfRepair(int custId) {
		System.out.println("in countOfRepair");
			Optional<User> temp=userRepo.findById(custId);
			User u=temp.get();
			int count=jobRepo.countCompletedService(u.getEmail());
			return count;
	}

	@Override
	public int countOfEnquiry(int custId) {
		System.out.println("in countOfEnquiry");
		return custEnqRepo.countBycustId(custId);
	}

}

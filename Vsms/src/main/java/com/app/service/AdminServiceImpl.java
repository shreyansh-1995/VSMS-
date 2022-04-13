package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerEnquiryRepo;
import com.app.dao.ServiceRequestRepo;
import com.app.dao.UserRepo;
import com.app.dto.EnquiryResponseDto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.Roles;
import com.app.pojos.ServiceRequest;
import com.app.pojos.User;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	CustomerEnquiryRepo custRepo;

	//setActive
	//setIsactive
	
	@Autowired
	ServiceRequestRepo servicerequestrepo;

	@Override
	public List<ResponseUserDto> fetchAllServiceAdvisor() {
		System.out.println("in fetchAllServiceAdvisor");
		List<User> users = userRepo.findAllByRole(Roles.SERVICEADVISOR);
		System.out.println(users.toString());

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			BeanUtils.copyProperties(u, dto);
			list.add(dto);

		}
		return list;

	}

	@Override
	public List<ResponseUserDto> fetchAllCustomers() {
		System.out.println(" in fetchAllCustomers");
		List<User> users = userRepo.findAllByRole(Roles.CUSTOMER);
		System.out.println(users.toString());

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			BeanUtils.copyProperties(u, dto);
			System.out.println(dto.toString());
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<ResponseUserDto> fetchAllMechanic() {
		System.out.println("in fetchAllMechanic");
		List<User> users = userRepo.findAllByRole(Roles.MECHANIC);

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			if (u.isActive() == true) {
				BeanUtils.copyProperties(u, dto);
				list.add(dto);
			}

		}
		return list;

	}

	@Override
	public String updateMechanic(int id) {
		System.out.println("in updateMechanic ");
		Optional<User> u = userRepo.findById(id);
		User mech = u.get();
		mech.setActive(true);
		userRepo.save(mech);
		return "Request Approved Successfully";
	}

	@Override
	public List<CustomerEnquiry> getCustomerEnquiry() {
		System.out.println("in getCustomerEnquiry");
		List<CustomerEnquiry> list = custRepo.findAllByisActive(true);
		return list;
	}

	@Override
	public String setEnquiryResponse(EnquiryResponseDto response) {
		System.out.println("in setEnquiryResponse");
		Optional<CustomerEnquiry> customerEnq = custRepo.findById(response.getCustId());
		CustomerEnquiry enquiry = customerEnq.get();
		enquiry.setResponse(response.getResponse());
		enquiry.setActive(false);
		custRepo.save(enquiry);
		return "Response is successfully Submitted";
	}

	@Override
	public List<ResponseUserDto> fetchPendingApproval() {
		System.out.println("in fetchPendingApproval");
		List<User> users = userRepo.findAllByRole(Roles.MECHANIC);

		List<ResponseUserDto> list = new ArrayList<>();
		for (User u : users) {
			ResponseUserDto dto = new ResponseUserDto();
			if (u.isActive() == false) {
				BeanUtils.copyProperties(u, dto);
				list.add(dto);
			}

		}
		return list;

	}

	@Override
	public List<ServiceRequest> getCustomerRequest() {
		System.out.println("in getCustomerRequest");
		List<ServiceRequest> list = servicerequestrepo.findAllByisactive(true);

		return list;
	}

	@Override
	public String setServiceResponse(ServiceRequest response) {
		System.out.println("in setServiceResponse");
		response.setIsactive(false);
		servicerequestrepo.save(response);
		return "Response is successfully Submitted";
	}

	@Override
	public int getAllMechanicCount() {
		System.out.println("in getAllMechanicCount");
		return userRepo.countByroleAndIsActive(Roles.MECHANIC, true);
	}

	@Override
	public int getAllServiceAdvisorCount() {
		System.out.println("in getAllServiceAdvisorCount");
		return userRepo.countByrole(Roles.SERVICEADVISOR);
	}

	@Override
	public int getAllCustomerCount() {
		System.out.println("in getAllCustomerCount ");
		return userRepo.countByrole(Roles.CUSTOMER);
	}

	@Override
	public long getAllEnquiry() {
		System.out.println("in getAllEnquiry");
		return custRepo.count();

	}

}

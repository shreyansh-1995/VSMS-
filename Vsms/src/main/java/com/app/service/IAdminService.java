package com.app.service;

import java.util.List;

import com.app.dto.EnquiryResponseDto;
import com.app.dto.ResponseUserDto;
import com.app.pojos.CustomerEnquiry;
import com.app.pojos.ServiceRequest;

public interface IAdminService {

	public String updateMechanic(int id);
	
	public String setServiceResponse(ServiceRequest response);
	
	public String setEnquiryResponse(EnquiryResponseDto response);
	
	public List<ResponseUserDto> fetchAllServiceAdvisor();

	public List<ResponseUserDto> fetchAllCustomers();

	public List<ResponseUserDto> fetchAllMechanic();
	
	public List<ResponseUserDto> fetchPendingApproval();

	public List<CustomerEnquiry> getCustomerEnquiry();

	public List<ServiceRequest> getCustomerRequest();

	public int getAllMechanicCount();

	public int getAllServiceAdvisorCount();

	public int getAllCustomerCount();

	public long getAllEnquiry();
	 
}

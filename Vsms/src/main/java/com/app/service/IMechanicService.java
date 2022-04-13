package com.app.service;

import java.util.List;

import com.app.pojos.JobCard;
import com.app.pojos.VehicleParts;

public interface IMechanicService {
	List<JobCard> showPendingRequest(String mech);
	
	List<VehicleParts> showallParts();
	
	public String serviceComplete(int id,List<String> allproducts,double billAmount);
	
	int getAllCompletedRequest(String mech);

	int getAllPendingRequest(String mechName);
}

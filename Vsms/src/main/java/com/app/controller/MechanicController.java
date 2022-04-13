package com.app.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProductAndBillDto;
//import com.app.dto.MechanicNameDto;
import com.app.service.IMechanicService;

@RestController
@RequestMapping("/mechanic")
@CrossOrigin(origins = "http://localhost:3000")
public class MechanicController {

	@Autowired
	private IMechanicService mechanicService;

	// Request to get all the pending work
	@GetMapping("/pendingwork")
	public ResponseEntity<?> showPendingJobCards(@RequestParam String mechName) {
		System.out.println("in showPendingJobCardsC");
		System.out.println("mechName =" + mechName);
		return new ResponseEntity<>(mechanicService.showPendingRequest(mechName), HttpStatus.OK);

	}

	// request to get the list of all parts
	@GetMapping("/getparts")
	public ResponseEntity<?> showParts() {
		System.out.println("in showPartsC");
		return new ResponseEntity<>(mechanicService.showallParts(), HttpStatus.OK);
	}

	// request to mark a jobcard as complete and add products in db by job id
	@PostMapping("/completed/{jobid}")
	public ResponseEntity<?> completedService(@PathVariable int jobid, @RequestBody AddProductAndBillDto body) {
		System.out.println("in completedServiceC");
		//System.out.println(jobid+" "+products.toString());
		List<String> allproducts = new ArrayList<>();
		String[] product = body.getProducts();
		//System.out.println(product.toString());
		for (String p : product) {
			allproducts.add(p);
		}
		//System.out.println(allproducts.toString());
		String message = mechanicService.serviceComplete(jobid, allproducts,body.getBillAmount());

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// request to get count of jobs completed
	@GetMapping("/completedreq")
	public ResponseEntity<?> getAllCompletedRequest(@RequestParam String mechName) {
		System.out.println("in getAllCompletedRequestC");
		int count = mechanicService.getAllCompletedRequest(mechName);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// request to get count of pending jobs
	@GetMapping("/pendingreq")
	public ResponseEntity<?> getAllPendingRequest(@RequestParam String mechName) {
		System.out.println("in getAllPendingRequestC");
		int count = mechanicService.getAllPendingRequest(mechName);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}

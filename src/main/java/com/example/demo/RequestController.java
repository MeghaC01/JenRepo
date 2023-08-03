package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("request")
@CrossOrigin
public class RequestController {

	@Autowired
	RequestDAO rservice;
	
	@PostMapping(value = "apply",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String requestadhar(@RequestBody Request req) {
		return rservice.storeRequest(req);
	}
	
	@GetMapping(value="viewAllRequest",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Request> getAllRequest() {
		return rservice.getAllRequests();
	}
	
	@DeleteMapping(value="deny/{adharid}")
	public String deleteRequest(@PathVariable("adharid") String adharid) {
		return rservice.denyRequest(adharid);
	}
	@PatchMapping(value = "approve",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String approveRequest(@RequestBody Request req) {
		return rservice.approveRequest(req);
	}
	
	@PatchMapping(value = "updateadhar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateAadhar(@RequestBody Request req) {
		return rservice.updateAdhar(req);
	}
	
	@GetMapping(value="viewmyadhar/{emailid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Request viewmyAadhar(@PathVariable("emailid") String emailid) {
		return rservice.viewmyAdhar(emailid);
	}
	
	 @GetMapping(value = "viewAllRequestsNotApproved", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Request> getAllRequestsNotApproved() {
	        return rservice.findAllRequestsNotApproved();
	    }
	 
	 @GetMapping(value = "viewAllRequestsApproved", produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Request> getAllRequestsApproved() {
	     return rservice.findAllRequestsApproved();
	 }
}


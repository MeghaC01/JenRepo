package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RequestDAO {

	@Autowired
	RequestRepo reqrepo;
	
	public String storeRequest(Request req) {
		reqrepo.save(req);
		return "Aadhar Application Request Submitted";
	}
	
	public List<Request> getAllRequests() {
		return reqrepo.findAll();
	}
	
	public String denyRequest(String adharid) {
		Optional<Request> result  = reqrepo.findById(adharid);
		if(result.isPresent()) {
			Request p = result.get();
			reqrepo.delete(p);
			return "Application Denied";
		}else {
			return "Application not present";
		}
	}
	public String approveRequest(Request req) {
		Optional<Request> result  = reqrepo.findById(req.getAdharid());
		if(result.isPresent()) {
			Request p = result.get();
			reqrepo.save(p);
			return "Application Approved";
		}else {
			return "Application not present";
		}
	}
	
	public String updateAdhar(Request req) {
		Optional<Request> result  = reqrepo.findById(req.getAdharid());
		if(result.isPresent()) {
			Request p = result.get();
			p.setDob(req.getDob());
			p.setName(req.getName());
			p.setAddress(req.getAddress());
			p.setGender(req.getGender());
			p.setPhone(req.getPhone());
			p.setStatus(req.getStatus());
			reqrepo.saveAndFlush(p);
			return "Aadhar Card Updation Requested";
		}else {
			return "Aadhar not present";
		}
	}
	
	public Request viewmyAdhar(String emailid) {
		return reqrepo.viewmyAdhar(emailid);
	}
	
	 public List<Request> findAllRequestsNotApproved() {
	        return reqrepo.findAllRequestsNotApproved();
	    }
	 
	 public List<Request> findAllRequestsApproved() {
		    return reqrepo.findAllApprovedRequests();
		}
}

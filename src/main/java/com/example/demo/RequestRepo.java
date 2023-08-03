package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, String> {
	
	@Query("select r from Request r where r.emailid = :emailid")
	public Request viewmyAdhar(@Param("emailid") String emailid);
	
	 @Query("SELECT r FROM Request r WHERE r.status <> 'approved'")
	 List<Request> findAllRequestsNotApproved();
	 
	 @Query("SELECT r FROM Request r WHERE r.status = 'approved'")
		List<Request> findAllApprovedRequests();

}

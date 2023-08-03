package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Request {
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String adharid;
	private String emailid;
	private String name;
	private String dob;
	private String address;
	private String phone;
	private String gender;
	private String status;
	@Override
	public String toString() {
		return "Request [adharid=" + adharid + ", emailid=" + emailid + ", name=" + name + ", dob=" + dob + ", address="
				+ address + ", phone=" + phone + ", gender=" + gender + ", status=" + status + "]";
	}
	
	
}

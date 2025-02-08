package com.example.dto;

public class UserDTO {
	
	
	
	private String companyName;
	private String email;
	private String gstNumber;
	private String contactNumber;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public UserDTO(String companyName, String email, String gstNumber, String contactNumber) {
		super();
		
		this.companyName = companyName;
		this.email = email;
		this.gstNumber = gstNumber;
		this.contactNumber = contactNumber;
	}
	
	

	
	
	

}

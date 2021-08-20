package com.sonata.jobtrack.model;

import java.sql.Date;

public class User {
	private Integer userId;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String role;
	private Boolean isActive;
	private Date dob;
	private Date createdOn;
	public User(){}
	public User(Integer userId, String userName, String email, String firstName, String lastName, String contactNumber,
			String role, Boolean isActive, Date dob, Date createdOn) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.role = role;
		this.isActive = isActive;
		this.dob = dob;
		this.createdOn = createdOn;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isAlive) {
		this.isActive = isAlive;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", role=" + role + ", isAlive="
				+ isActive + ", dob=" + dob + ", createdOn=" + createdOn + "]";
	}
}

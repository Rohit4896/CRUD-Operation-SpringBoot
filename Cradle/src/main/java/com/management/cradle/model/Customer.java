package com.management.cradle.model;

import jakarta.persistence.*;

@Entity
@Table(name="Customers")
@SecondaryTable(name = "customerAddresses", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customerId"))
public class Customer {
	
	@Id
	@Column(name="customerId")
	private String customerId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;

	@Column(name="emailId")
	private String emailId;
	
	@Column(name="mobileNumber")
	private String mobileNo;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "addressId", table = "customerAddresses")
	private String addressId;
	
	@Column(name = "completeAddress", table = "customerAddresses")
	private String completeAddress;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password=" + password + ", addressId="
				+ addressId + ", completeAddress=" + completeAddress + "]";
	}
	
}

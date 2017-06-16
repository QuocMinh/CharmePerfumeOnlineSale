package com.sale.charme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {
	
	@Id
	private String customerId;
	
	private String fullName;
	private String address;
	private String phone;
	private String email;
	
	@DBRef
	private CustomerType customerTypeId;
	
	public Customer() {
		super();
	}

	public Customer(String customerId, String fullName, String address,
			String phone, String email, CustomerType customerTypeId) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.customerTypeId = customerTypeId;
	}

	public Customer(String fullName, String address, String phone,
			String email, CustomerType customerTypeId) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerType getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(CustomerType customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName
				+ ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", customerTypeId=" + customerTypeId + "]";
	}

}

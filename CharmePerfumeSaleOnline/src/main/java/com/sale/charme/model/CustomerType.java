package com.sale.charme.model;

import org.springframework.data.annotation.Id;

public class CustomerType {

	@Id
	private String customerTypeId;

	private String customerType;
	private String decription;

	public CustomerType() {
		super();
	}

	public CustomerType(String customerTypeId, String customerType,
			String decription) {
		super();
		this.customerTypeId = customerTypeId;
		this.customerType = customerType;
		this.decription = decription;
	}

	public CustomerType(String customerType, String decription) {
		super();
		this.customerType = customerType;
		this.decription = decription;
	}

	public String getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "CustomerType [customerTypeId=" + customerTypeId
				+ ", customerType=" + customerType + ", decription="
				+ decription + "]";
	}

}

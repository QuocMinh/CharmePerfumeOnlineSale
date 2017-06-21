package com.sale.charme.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Person {
	
	private String fullName;
	private String sex;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dob;
	private Address address;
	private String phone;
	private String email;
	
	public Person() {
		super();
		address = new Address();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			this.dob = formatter.parse("01/01/2001");
		} catch (ParseException e) {
			e.printStackTrace();
			this.dob = new Date();
		}
	}

	public Person(String fullName, String sex, Date dob, Address address,
			String phone, String email) {
		super();
		this.fullName = fullName;
		this.sex = sex;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
	
	public void setDobString(String dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			this.dob = formatter.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
			
			this.dob = null;
		}
	}

	public Date convertStringToDOB(String source) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			return formatter.parse(source);
			
		} catch (ParseException e) {
			e.printStackTrace();
			
			return new Date();
		}
	}
	
	public String convertDOBToString(Date dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return formatter.format(dob);
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", sex=" + sex + ", dob=" + dob
				+ ", address=" + address + ", phone=" + phone + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
}

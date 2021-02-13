package com.sale.charme.model;

public class Address {
	
	private String no;
	private String street;
	private String ward;
	private String district;
	private String city;
	
	public Address() {
		super();
		// no = street = ward = district = city = Constant.NEW_OBJECT;
	}

	public Address(String no, String street, String ward, String district,
			String city) {
		super();
		this.no = no;
		this.street = street;
		this.ward = ward;
		this.district = district;
		this.city = city;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	@Override
	public String toString() {
		String address = "";
		
		address = address + ((no == null) ? "" : no + ", ");
		address = address + ((street == null) ? "" : street + ", ");
		address = address + ((ward == null) ? "" : ward + ", ");
		address = address + ((district == null) ? "" : district + ", ");
		address = address + ((city == null) ? "" : city);
		
		return address == null ? "Chưa cập nhật" : address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((ward == null) ? 0 : ward.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (ward == null) {
			if (other.ward != null)
				return false;
		} else if (!ward.equals(other.ward))
			return false;
		return true;
	}

}

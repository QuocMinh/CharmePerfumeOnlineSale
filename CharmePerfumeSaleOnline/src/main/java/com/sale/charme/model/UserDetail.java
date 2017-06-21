package com.sale.charme.model;

public class UserDetail extends Person {
	
	private String pathImg;
	
	public UserDetail() {
		super();
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	@Override
	public String toString() {
		return "UserDetail [pathImg=" + pathImg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pathImg == null) ? 0 : pathImg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetail other = (UserDetail) obj;
		if (pathImg == null) {
			if (other.pathImg != null)
				return false;
		} else if (!pathImg.equals(other.pathImg))
			return false;
		return true;
	}

}

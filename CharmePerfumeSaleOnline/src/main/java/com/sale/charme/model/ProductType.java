package com.sale.charme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductType {
	
	@Id
	private String productTypeId;
	
	private String productTypeName;
	private String decription;
	
	public ProductType() {
		super();
	}

	public ProductType(String productTypeId, String productTypeName,
			String decription) {
		super();
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.decription = decription;
	}

	public ProductType(String productTypeName, String decription) {
		super();
		this.productTypeName = productTypeName;
		this.decription = decription;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "ProductType [productTypeId=" + productTypeId
				+ ", productTypeName=" + productTypeName + ", decription="
				+ decription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((decription == null) ? 0 : decription.hashCode());
		result = prime * result
				+ ((productTypeId == null) ? 0 : productTypeId.hashCode());
		result = prime * result
				+ ((productTypeName == null) ? 0 : productTypeName.hashCode());
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
		ProductType other = (ProductType) obj;
		if (decription == null) {
			if (other.decription != null)
				return false;
		} else if (!decription.equals(other.decription))
			return false;
		if (productTypeId == null) {
			if (other.productTypeId != null)
				return false;
		} else if (!productTypeId.equals(other.productTypeId))
			return false;
		if (productTypeName == null) {
			if (other.productTypeName != null)
				return false;
		} else if (!productTypeName.equals(other.productTypeName))
			return false;
		return true;
	}

}

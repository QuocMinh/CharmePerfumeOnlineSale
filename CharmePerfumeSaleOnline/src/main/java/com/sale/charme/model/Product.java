package com.sale.charme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private String productId;
	
	private String productName;
	private String unit;
	private float volume;
	private String describe;
	
	@DBRef
	private ProductType productType;
	
	@DBRef
	private UnitPrice unitPrice;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName, String unit,
			float volume, String describe, ProductType productType,
			UnitPrice unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.productType = productType;
		this.unitPrice = unitPrice;
	}

	public Product(String productName, String unit, float volume,
			String describe, ProductType productType, UnitPrice unitPrice) {
		super();
		this.productName = productName;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.productType = productType;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", unit=" + unit + ", volume=" + volume
				+ ", describe=" + describe + ", productType=" + productType
				+ ", unitPrice=" + unitPrice + "]";
	}

	public UnitPrice getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(UnitPrice unitPrice) {
		this.unitPrice = unitPrice;
	}

}
package com.sale.charme.model;

import java.util.List;

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
	private List<UnitPrice> unitPrices;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName,
			ProductType productType, String unit, float volume,
			String describe, List<UnitPrice> unitPrices) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.unitPrices = unitPrices;
	}

	public Product(String productName, ProductType productType, String unit,
			float volume, String describe, List<UnitPrice> unitPrices) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.unitPrices = unitPrices;
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

	public List<UnitPrice> getUnitPrices() {
		return unitPrices;
	}

	public void setUnitPrices(List<UnitPrice> unitPrices) {
		this.unitPrices = unitPrices;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productType=" + productType + ", unit="
				+ unit + ", volume=" + volume + ", describe=" + describe
				+ ", unitPrices=" + unitPrices + "]";
	}

}
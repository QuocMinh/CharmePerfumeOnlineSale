package com.sale.charme.model;

import org.springframework.data.annotation.Id;

public class UnitPrice {
	
	@Id
	private String uniPriceId;
	
	private long wholesalePrice5;
	private long wholesalePrice512;
	private long wholesalePrice12;
	private long wholesalePrice24;
	private long wholesalePrice48;
	private long retailPrice;
	
	
	public UnitPrice() {
		super();
	}

	public UnitPrice(String uniPriceId) {
		super();
		this.uniPriceId = uniPriceId;
	}

	public UnitPrice(String uniPriceId, long wholesalePrice5,
			long wholesalePrice512, long wholesalePrice12,
			long wholesalePrice24, long wholesalePrice48, long retailPrice) {
		super();
		this.uniPriceId = uniPriceId;
		this.wholesalePrice5 = wholesalePrice5;
		this.wholesalePrice512 = wholesalePrice512;
		this.wholesalePrice12 = wholesalePrice12;
		this.wholesalePrice24 = wholesalePrice24;
		this.wholesalePrice48 = wholesalePrice48;
		this.retailPrice = retailPrice;
	}

	public UnitPrice(long wholesalePrice5, long wholesalePrice512,
			long wholesalePrice12, long wholesalePrice24,
			long wholesalePrice48, long retailPrice) {
		super();
		this.wholesalePrice5 = wholesalePrice5;
		this.wholesalePrice512 = wholesalePrice512;
		this.wholesalePrice12 = wholesalePrice12;
		this.wholesalePrice24 = wholesalePrice24;
		this.wholesalePrice48 = wholesalePrice48;
		this.retailPrice = retailPrice;
	}

	public String getUniPriceId() {
		return uniPriceId;
	}

	public void setUniPriceId(String uniPriceId) {
		this.uniPriceId = uniPriceId;
	}

	public long getWholesalePrice5() {
		return wholesalePrice5;
	}

	public void setWholesalePrice5(long wholesalePrice5) {
		this.wholesalePrice5 = wholesalePrice5;
	}

	public long getWholesalePrice512() {
		return wholesalePrice512;
	}

	public void setWholesalePrice512(long wholesalePrice512) {
		this.wholesalePrice512 = wholesalePrice512;
	}

	public long getWholesalePrice12() {
		return wholesalePrice12;
	}

	public void setWholesalePrice12(long wholesalePrice12) {
		this.wholesalePrice12 = wholesalePrice12;
	}

	public long getWholesalePrice24() {
		return wholesalePrice24;
	}

	public void setWholesalePrice24(long wholesalePrice24) {
		this.wholesalePrice24 = wholesalePrice24;
	}

	public long getWholesalePrice48() {
		return wholesalePrice48;
	}

	public void setWholesalePrice48(long wholesalePrice48) {
		this.wholesalePrice48 = wholesalePrice48;
	}

	public long getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(long retailPrice) {
		this.retailPrice = retailPrice;
	}

	@Override
	public String toString() {
		return "UnitPrice [uniPriceId=" + uniPriceId + ", wholesalePrice5="
				+ wholesalePrice5 + ", wholesalePrice512=" + wholesalePrice512
				+ ", wholesalePrice12=" + wholesalePrice12
				+ ", wholesalePrice24=" + wholesalePrice24
				+ ", wholesalePrice48=" + wholesalePrice48 + ", retailPrice="
				+ retailPrice + "]";
	}
	
	
}

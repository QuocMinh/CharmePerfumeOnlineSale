package com.sale.charme.dao;

import com.sale.charme.model.UnitPrice;

public interface UnitPriceRepositoryCustom {
	
	public UnitPrice findByCustomerType(String customerType);

}

package com.sale.charme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sale.charme.dao.UnitPriceRepositoryCustom;
import com.sale.charme.model.UnitPrice;

public class UnitPriceRepositoryImpl implements UnitPriceRepositoryCustom {
	
	@Autowired
	MongoTemplate template;

	@Override
	public UnitPrice findByCustomerType(String customerTypeId) {
		
		Query query = new Query();
		query.addCriteria(
				Criteria
					.where("customerType.$ref")
					.is("customerType")
					.and("customerType.$id")
					.is(customerTypeId)
				);
		
		UnitPrice unitPrice = template.findOne(query, UnitPrice.class);
		
		return unitPrice;
	}
	

}

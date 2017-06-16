package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sale.charme.dao.UnitPriceRepositoryCustom;
import com.sale.charme.model.UnitPrice;

public interface UnitPriceRepository extends MongoRepository<UnitPrice, String>, UnitPriceRepositoryCustom {
	
}

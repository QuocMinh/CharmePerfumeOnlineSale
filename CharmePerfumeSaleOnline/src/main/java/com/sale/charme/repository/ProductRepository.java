package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sale.charme.dao.ProductRepositoryCustom;
import com.sale.charme.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
	
	@Query("{productName : ?0}")
	Product findByProductName(String productName);
	
}

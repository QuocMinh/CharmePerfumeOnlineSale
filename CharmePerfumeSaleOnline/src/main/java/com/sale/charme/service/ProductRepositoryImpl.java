package com.sale.charme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sale.charme.dao.ProductRepositoryCustom;
import com.sale.charme.model.Product;
import com.sale.charme.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Page<Product> findAllPageable(Pageable pageable) {
		
		return productRepository.findAll(pageable);
	}

}

package com.sale.charme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sale.charme.dao.ProductTypeRepositoryCustom;
import com.sale.charme.model.ProductType;
import com.sale.charme.repository.ProductTypeRepository;

public class ProductTypeRepositoryImpl implements ProductTypeRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	ProductTypeRepository loaiMHRepo;
	
	@Override
	public ProductType printHello(ProductType loaiMH) {
		
		return null;
	}

	@Override
	public Page<ProductType> findAllPageable(Pageable pageable) {
		return loaiMHRepo.findAll(pageable);
	}

}
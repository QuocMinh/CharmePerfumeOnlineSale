package com.sale.charme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sale.charme.dao.ProductRepositoryCustom;
import com.sale.charme.model.Product;
import com.sale.charme.model.UnitPrice;
import com.sale.charme.repository.ProductRepository;
import com.sale.charme.repository.ProductTypeRepository;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Override
	public Page<Product> findAllPageable(Pageable pageable) {
		
		return productRepository.findAll(pageable);
	}

	@Override
	public Product updateProduct(Product productUpdated) {
		/*
		List<UnitPrice> newUnitPrices = productUpdated.getUnitPrices(); // Get UnitPrice of new Product
		
		if(newUnitPrices == null || newUnitPrices.isEmpty()) { // Check if UnitPrice is NULL
			
			// --> Then ...
			// Find Product by Id 
			Product localProduct = productRepository.findOne(productUpdated.getProductId());
			
			// Update product
			localProduct.setProductName(productUpdated.getProductName());
			localProduct.setProductType(productTypeRepository.findOne(productUpdated.getProductType().getProductTypeId()));
			localProduct.setDescribe(productUpdated.getDescribe());
			localProduct.setUnit(productUpdated.getUnit());
			localProduct.setVolume(productUpdated.getVolume());
			
			productRepository.save(localProduct); // Update product to DB
			
			return localProduct;
		}
		
		// --> Else ...
		// Update product
		productRepository.save(productUpdated);
		*/
		return null;
		
	}

	@Override
	public Product updateUnitPrice(String productId, List<UnitPrice> unitPrices) {
		// TODO Auto-generated method stub
		return null;
	}

}

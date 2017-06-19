package com.sale.charme.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.model.ProductType;

public interface ProductTypeRepositoryCustom {
	
	Page<ProductType> findAllPageable(Pageable pageable);
	
}

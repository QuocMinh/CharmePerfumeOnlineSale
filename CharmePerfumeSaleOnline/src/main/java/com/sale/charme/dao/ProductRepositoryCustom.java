package com.sale.charme.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.model.Product;

public interface ProductRepositoryCustom {
	
	Page<Product> findAllPageable(Pageable pageable);

}

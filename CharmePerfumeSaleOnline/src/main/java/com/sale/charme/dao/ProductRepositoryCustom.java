package com.sale.charme.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.model.Product;
import com.sale.charme.model.UnitPrice;

public interface ProductRepositoryCustom {
	
	public Page<Product> findAllPageable(Pageable pageable);
	public Product updateProduct(Product productUpdated);
	public Product updateUnitPrice(String productId, List<UnitPrice> unitPrices);

}

package com.sale.charme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sale.charme.dao.ProductTypeRepositoryCustom;
import com.sale.charme.model.ProductType;

public interface ProductTypeRepository extends MongoRepository<ProductType, String>, ProductTypeRepositoryCustom {
	
	@Query("{'limit' : ?0}")
	public List<ProductType> get10LoaiMatHang(int start);
	
}

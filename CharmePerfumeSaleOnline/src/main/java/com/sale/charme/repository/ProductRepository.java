package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sale.charme.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}

package com.sale.charme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sale.charme.dao.LoaiMatHangRepositoryCustom;
import com.sale.charme.model.LoaiMatHang;

public interface LoaiMatHangRepository extends MongoRepository<LoaiMatHang, String>, LoaiMatHangRepositoryCustom {
	
	@Query("{maLoai : ?0}")
	public LoaiMatHang findByMaLoai(String maLoai);
	
	@Query("{'limit' : ?0}")
	public List<LoaiMatHang> get10LoaiMatHang(int start);
	
}

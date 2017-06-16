package com.sale.charme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sale.charme.dao.LoaiMatHangRepositoryCustom;
import com.sale.charme.model.LoaiMatHang;
import com.sale.charme.repository.LoaiMatHangRepository;

public class LoaiMatHangRepositoryImpl implements LoaiMatHangRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	LoaiMatHangRepository loaiMHRepo;
	
	@Override
	public LoaiMatHang printHello(LoaiMatHang loaiMH) {
		
		return null;
	}

	@Override
	public Page<LoaiMatHang> findAllPageable(Pageable pageable) {
		return loaiMHRepo.findAll(pageable);
	}

}
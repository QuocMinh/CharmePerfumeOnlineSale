package com.sale.charme.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.model.LoaiMatHang;

public interface LoaiMatHangRepositoryCustom {
	
	Page<LoaiMatHang> findAllPageable(Pageable pageable);
	
	public LoaiMatHang printHello(LoaiMatHang loaiMH);

}

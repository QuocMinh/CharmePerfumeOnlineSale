package com.sale.charme.model;

import org.springframework.data.annotation.Id;

public class ChiTietMatHang {
	
	@Id
	private String id;
	
	private String loai; // Chat ran hoac Chat long
	private String khoiLuong; // Khoi luong hoac The tich
	private String dacTrung;
	private String moTa;
	
	public ChiTietMatHang() {
		super();
	}

	public ChiTietMatHang(String id, String loai, String khoiLuong,
			String dacTrung, String moTa) {
		super();
		this.id = id;
		this.loai = loai;
		this.khoiLuong = khoiLuong;
		this.dacTrung = dacTrung;
		this.moTa = moTa;
	}

	public ChiTietMatHang(String loai, String khoiLuong, String dacTrung,
			String moTa) {
		super();
		this.loai = loai;
		this.khoiLuong = khoiLuong;
		this.dacTrung = dacTrung;
		this.moTa = moTa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getKhoiLuong() {
		return khoiLuong;
	}

	public void setKhoiLuong(String khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	public String getDacTrung() {
		return dacTrung;
	}

	public void setDacTrung(String dacTrung) {
		this.dacTrung = dacTrung;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}

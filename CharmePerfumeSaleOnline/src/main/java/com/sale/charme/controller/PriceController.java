package com.sale.charme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.charme.model.Product;
import com.sale.charme.model.UnitPrice;
import com.sale.charme.repository.ProductRepository;
import com.sale.charme.repository.UnitPriceRepository;

@Controller
public class PriceController {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UnitPriceRepository unitPriceRepository;
	
	@GetMapping("/price")
	public String listPrice(Model model) {
		List<Product> products = productRepository.findAll();
		
		model.addAttribute("products", products);
		
		return "price";
	}
	
	@GetMapping("/update-price")
	public String updatePrice(Model model,
			@RequestParam("id") String productId) {
		
		UnitPrice unitPrice = unitPriceRepository.findOne(productId);
		Product product = productRepository.findOne(productId);
		
		if(unitPrice == null) {
			unitPrice = new UnitPrice(productId);
		}
		
		model.addAttribute("unitPrice", unitPrice);
		model.addAttribute("product", product);
		
		return "price-update";
	}
	
	@PostMapping("/update-price")
	public String handleUpdatePrice(@ModelAttribute("unitPrice") UnitPrice unitPrice) {
		
		System.out.println(unitPrice);
		
		return "redirect:/price-update?id=" + unitPrice;
	}
	
}

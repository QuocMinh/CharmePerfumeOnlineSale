package com.sale.charme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sale.charme.model.Product;
import com.sale.charme.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/list-product")
	public String showPage(Model model){
		Product product = productRepository.findOne("NHCHSO25");
		
		model.addAttribute("product", product);
		
		return "bill-test";
	}

}

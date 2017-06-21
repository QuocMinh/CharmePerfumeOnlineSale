package com.sale.charme.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.charme.model.Pager;
import com.sale.charme.model.Product;
import com.sale.charme.repository.ProductRepository;
import com.sale.charme.service.Constant;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/list-product")
	public String showPage(Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		
		int evalPageSize = pageSize.orElse(Constant.INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? Constant.INITIAL_PAGE : page.get() - 1;
		
		Page<Product> products = productRepository
				.findAllPageable(new PageRequest(evalPage, evalPageSize));
		
		Pager pager = new Pager(products.getTotalPages(), products.getNumber(), Constant.BUTTONS_TO_SHOW);
		
		model.addAttribute("products", products);
		model.addAttribute("productNew", new Product());
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", Constant.PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		return "product";
	}

}

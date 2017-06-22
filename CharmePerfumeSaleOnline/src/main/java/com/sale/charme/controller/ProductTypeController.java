package com.sale.charme.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.charme.model.ProductType;
import com.sale.charme.model.Pager;
import com.sale.charme.repository.ProductTypeRepository;

@Controller
public class ProductTypeController {
	
	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/list-product-type")
	public String showAll(Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		
		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<ProductType> productTypes = productTypeRepository.findAllPageable(
					new PageRequest(evalPage, evalPageSize)
				);
		Pager pager = new Pager(productTypes.getTotalPages(), productTypes.getNumber(), 
				BUTTONS_TO_SHOW);
		
		model.addAttribute("productTypes", productTypes);
		model.addAttribute("newProductType", new ProductType());
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		return "loaimathang";
	}
	
	@PostMapping("/create-product-type")
	public String createProductType(
			@ModelAttribute("newProductType") ProductType newProductType) {
		
		String newProductTypeId = newProductType.getProductTypeId();
		
		if(!productTypeRepository.exists(newProductTypeId)) {
			productTypeRepository.insert(newProductType);
			
			return "redirect:/list-product-type?success=" + newProductTypeId;
		}
		
		return "redirect:/list-product-type?error=" + newProductTypeId;
	}
	
	@GetMapping("/update-product-type")
	public String updateProductType(Model model,
			@RequestParam("id") String productTypeId) {
		
		// Get product type from DB by product type id
		ProductType productType = productTypeRepository.findOne(productTypeId); 
		
		model.addAttribute("productType", productType);
		
		return "product-type-update";
	}
	
	@PostMapping("/update-product-type")
	public String handleUpdate(@ModelAttribute ProductType productType) {
		
		productTypeRepository.save(productType);
		
		return "redirect:/update-product-type?id=" + productType.getProductTypeId() + "&success";
	}
	
	
	@GetMapping("/delete-product-type")
	public String handleDelete(@RequestParam("id") String id) {
		
		productTypeRepository.delete(id);
		
		return "redirect:/list-product-type?deleted=" + id;
	}
	
}

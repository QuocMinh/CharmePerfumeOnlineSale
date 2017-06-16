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
	ProductTypeRepository loaiMHRepo;
	
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
		
		Page<ProductType> loaiMHs = loaiMHRepo.findAllPageable(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(loaiMHs.getTotalPages(), loaiMHs.getNumber(), BUTTONS_TO_SHOW);
		
		model.addAttribute("loaiMHs", loaiMHs);
		model.addAttribute("loaiMHNew", new ProductType());
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		loaiMHRepo.printHello(new ProductType());
		
		return "loaimathang";
	}
	
	@PostMapping("/update-product-type")
	public String handleUpdate(@ModelAttribute ProductType loaiMH) {
		
		loaiMHRepo.save(loaiMH);
		
		return "redirect:/list-product-type";
	}
	
	
	@GetMapping("/delete-product-type")
	public String handleDelete(@RequestParam String id) {
		logger.info("Delete --> id = " + id);
		
		loaiMHRepo.delete(id);
		
		return "redirect:/list-product-type";
	}
	
}

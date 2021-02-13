package com.sale.charme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.charme.model.Pager;
import com.sale.charme.model.Product;
import com.sale.charme.model.ProductType;
import com.sale.charme.model.UnitPrice;
import com.sale.charme.repository.ProductRepository;
import com.sale.charme.repository.ProductTypeRepository;
import com.sale.charme.service.Constant;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
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
		model.addAttribute("newProduct", new Product());
		model.addAttribute("pageSizes", Constant.PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		// Get product type for form create
		List<ProductType> productTypes = productTypeRepository.findAll();
		model.addAttribute("productTypes", productTypes);
		
		return "product";
		
	}
	
	@PostMapping("/create-product")
	public String createProduct(@ModelAttribute("newProduct") Product newProduct) {
		String newProductId = newProduct.getProductId();
		
		if(!productRepository.exists(newProductId)) {
			// Get Product Type from db
			ProductType productType = productTypeRepository.findOne(newProduct
					.getProductType().getProductTypeId());
			
			newProduct.setProductType(productType); // Set product type for new producy
			
			productRepository.insert(newProduct); // Save new product to db
			
			return "redirect:/list-product?success=" + newProductId;
		}
		
		return "redirect:/list-product?error=" + newProductId;
	}
	
	@GetMapping("/update-product")
	public String udpateProduct(Model model,
			@RequestParam("id") String id) {
		
		// Find product by id
		Product product = productRepository.findOne(id);
		
		// Find all product type
		List<ProductType> productTypes = productTypeRepository.findAll();
		
		// Send to view
		model.addAttribute("product", product);
		model.addAttribute("productTypes", productTypes);
		
		return "product-update";
	}
	
	@PostMapping("/update-product")
	public String handleUpdateProduct(@ModelAttribute("product") Product updatedProduct) {
		
		// Get Product Type from db
		ProductType productType = productTypeRepository.findOne(updatedProduct
				.getProductType().getProductTypeId());
		
		// Update unit price
		List<UnitPrice> updatedUnitPrices = productRepository.findOne(updatedProduct.getProductId()).getUnitPrices();
		
		updatedProduct.setProductType(productType);
		
		productRepository.save(updatedProduct); 
		
		return "redirect:/update-product?success&id=" + updatedProduct.getProductId();
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") String id) {
		
		productRepository.delete(id);
		
		return "redirect:/list-product?deleted=" + id;
	}
	
	@GetMapping("/view-product")
	public String viewProductDetails(Model model,
			@RequestParam("id") String productId) {
		
		// Find and send product to view with request id
		model.addAttribute("product", productRepository.findOne(productId));
		
		return "product-details";
	}

}

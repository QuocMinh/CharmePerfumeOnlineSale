package com.sale.charme.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sale.charme.model.Address;
import com.sale.charme.model.Customer;
import com.sale.charme.model.CustomerType;
import com.sale.charme.model.Product;
import com.sale.charme.model.ProductType;
import com.sale.charme.model.Role;
import com.sale.charme.model.UnitPrice;
import com.sale.charme.model.User;
import com.sale.charme.model.UserDetail;
import com.sale.charme.repository.CustomerRepository;
import com.sale.charme.repository.CustomerTypeRepository;
import com.sale.charme.repository.ProductRepository;
import com.sale.charme.repository.ProductTypeRepository;
import com.sale.charme.repository.RoleRepository;
import com.sale.charme.repository.UnitPriceRepository;
import com.sale.charme.repository.UserRepository;
import com.sale.charme.service.Constant;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	@Autowired
	private UnitPriceRepository unitPriceRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductTypeRepository productTypeRepository ;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// CREATE ROLE:
		if(roleRepository.findOne(Constant.ROLE_ADMIN) == null) {
			roleRepository.save(new Role(Constant.ROLE_ADMIN,
					Constant.ROLE_ADMIN_DETAIL));
			
		}if(roleRepository.findOne(Constant.ROLE_MEMBER) == null) {
			roleRepository.save(new Role(Constant.ROLE_MEMBER,
					Constant.ROLE_MEMBER_DETAIL));
		}
		
		// ADMIN ACCOUNT:
		if(userRepository.findOne("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName(Constant.ROLE_ADMIN));
			roles.add(roleRepository.findByRoleName(Constant.ROLE_MEMBER));
			admin.setUserRole(roles);
			
			// User Details
			UserDetail userDetail = new UserDetail();
			userDetail.setFullName("Chau Quoc Minh");
			userDetail.setAddress(new Address("37", "Tra Khua", "Long Thanh", "Vinh Loi", "Bac Lieu"));
			userDetail.setPhone("0123 94 96 986");
			
			admin.setUserDetail(userDetail);
			
			userRepository.save(admin);
		}
		
		// MEMBER ACCOUNT:
		if(userRepository.findOne("member") == null) {
			User member = new User();
			member.setUsername("member");
			member.setPassword(passwordEncoder.encode("member"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName(Constant.ROLE_MEMBER));
			member.setUserRole(roles);
			member.setUserDetail(new UserDetail());
			
			userRepository.save(member);
		}
		
		// CUSTOMER_TYPE:
		if(customerTypeRepository.findOne("KHLE") == null) {
			customerTypeRepository.save(new CustomerType("KHLE", "Khách bán lẻ", null));
		}
		if(customerTypeRepository.findOne("SI05") == null) {
			customerTypeRepository.save(new CustomerType("SI05", "Khách sỉ 5", "Khách lấy sỉ 5 chai"));
		}
		
		// CUSTOMER:
		if(customerRepository.findByCustomerFullName("MINH") == null) {
			Customer customer = new Customer();
			customer.setFullName("MINH");
			customer.setCustomerTypeId(customerTypeRepository.findByCustomerType("LE"));
			customerRepository.save(customer);
		}
		if(customerRepository.findByCustomerFullName("NHI") == null) {
			Customer customer = new Customer();
			customer.setFullName("NHI");
			customer.setCustomerTypeId(customerTypeRepository.findByCustomerType("SI"));
			customerRepository.save(customer);
		}
		
		
		// UNIT_PRICE
		if(unitPriceRepository.findByCustomerType("KHLE") == null) {
			UnitPrice unitPrice = new UnitPrice();
			unitPrice.setCustomerType(customerTypeRepository.findOne("KHLE"));
			unitPrice.setPrice(100000);
			unitPrice.setDecription("Gia ban le");
			
			unitPriceRepository.save(unitPrice);
		}
		
		if(unitPriceRepository.findByCustomerType("SI05") == null) {
			UnitPrice unitPrice = new UnitPrice();
			unitPrice.setCustomerType(customerTypeRepository.findOne("SI05"));
			unitPrice.setPrice(50000);
			unitPrice.setDecription("Gia ban si 5 chai");
			
			unitPriceRepository.save(unitPrice);
		}
		
		// PRODUCT_TYPE:
		if(!productTypeRepository.exists("NHNA")) {
			ProductType productType = new ProductType();
			
			productType.setProductTypeId("NHNA");
			productType.setProductTypeName("Nước hoa Nam");
			productType.setDecription("Các loại nước hoa Charme dành cho Nam giới");
			
			productTypeRepository.save(productType);
		}
		
		if(productTypeRepository.findOne("NHNU") == null) {
			ProductType productType = new ProductType();
			
			productType.setProductTypeId("NHNU");
			productType.setProductTypeName("Nước hoa Nữ");
			productType.setDecription("Các loại nước hoa Charme dành cho Nữ giới");
			
			productTypeRepository.save(productType);
		}
		
		// PRODUCT:
		if(productRepository.findOne("NHCHSO25") == null) {
			Product product = new Product();
			product.setProductId("NHCHSO25");
			product.setProductName("So sexy 25ml");
			List<UnitPrice> unitPrices = unitPriceRepository.findAll();
			product.setUnitPrices(unitPrices);
			ProductType productType = productTypeRepository.findOne("NHNU");
			product.setProductType(productType);
			
			productRepository.save(product);
			
		}
	}
}

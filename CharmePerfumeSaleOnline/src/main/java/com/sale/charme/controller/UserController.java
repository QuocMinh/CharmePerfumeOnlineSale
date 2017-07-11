package com.sale.charme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.charme.model.Pager;
import com.sale.charme.model.Role;
import com.sale.charme.model.User;
import com.sale.charme.repository.RoleRepository;
import com.sale.charme.repository.UserRepository;
import com.sale.charme.service.Constant;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/list")
	public String showUserPage(Model model, 
			@ModelAttribute User user,
			@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		
		int evalPageSize = pageSize.orElse(Constant.INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? Constant.INITIAL_PAGE : page.get() - 1;
		
		// Get all User on DB to paging
		Page<User> users = userRepository.findAll(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(users.getTotalPages(), users.getNumber(), Constant.BUTTONS_TO_SHOW);
		
		List<Role> roles = roleRepository.findAll(); // get all roles from DB
		
		model.addAttribute("users", users);
		model.addAttribute("roles", roles);
		model.addAttribute("newUser", user);
		model.addAttribute("pager", pager);
		
		return "user";
	}
	
	@GetMapping("/{username}/details")
	public String showUserDetails(Model model, @PathVariable String username) {
		User user = userRepository.findOne(username);
		
		model.addAttribute("user", user);
		
		return "user-details";
	}

	@PostMapping("/create")
	public String createUser(@ModelAttribute User user) {
		
		if(!userRepository.exists(user.getUsername())) {
			userRepository.insert(user); // save user to DB
			
			return "redirect:/user/list?success";
		}
		
		return "redirect:/user/list?error";
	}
	
	@GetMapping("/{username}/update")
	public String updateUser(Model model, @PathVariable String username) {
		User user = userRepository.findOne(username); // Get user by username on DB
		
		model.addAttribute("user", user); // Send user to view
		model.addAttribute("dob", user.getUserDetail().getDobString()); // send dob String to view
		
		return "user-update";
	}
	
	@PostMapping("/update")
	public String handleUpdateUser(Model model,
			@ModelAttribute("user") User user,
			@RequestParam("dob") String dob) {
		
		user.getUserDetail().setDobString(dob); // Update dob
		
		userRepository.save(user); // save user to db
		
		model.addAttribute("success", user.getUsername());
		
		return "redirect:/user/" + user.getUsername() + "/update?success";
	}
	
	@GetMapping("/{username}/delete")
	public String deleteUser(Model model, @PathVariable String username) {
		userRepository.delete(username);
		
		return "redirect:/user/list?deleted=" + username;
	}
	
	
}

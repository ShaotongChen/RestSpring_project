package com.cogent.productmanagementthyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cogent.productmanagementthyme.dto.LoginUser;
import com.cogent.productmanagementthyme.dto.Product;
import com.cogent.productmanagementthyme.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("list_product", ps.getAllProducts());
		return "index";
		
	}
	
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {
		System.out.println("come here");
		Product p = new Product();
		model.addAttribute("product", p);
		return "new_product";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		ps.saveProduct(product);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		
		Product product = ps.getProductById(id);
		model.addAttribute("product", product);
		return "update_product";
		
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") int id) {
		
		ps.deleteProductById(id);
		return "redirect:/";
	}
	@GetMapping("/loginD")
	public String login(Model m) 
	{
		LoginUser lu = new LoginUser("bbb","bbb");
		m.addAttribute("user", lu);
		return "login";
		
	}
/*	@GetMapping("/login")
	public String loging()
	{
	return "/login";	
	}*/
}

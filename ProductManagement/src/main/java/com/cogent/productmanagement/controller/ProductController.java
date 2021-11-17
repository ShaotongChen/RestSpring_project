package com.cogent.productmanagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cogent.productmanagement.dto.Product;
import com.cogent.productmanagement.exception.ResourceNotFoundException;
import com.cogent.productmanagement.repository.ProductRepository;


@RestController
public class ProductController {

	@Autowired
	ProductRepository pr;
	@GetMapping("/")
	public List<Product> getProducts(){
		
		List<Product> list = pr.findAll();
		list.forEach(System.out::println);
		return list;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) throws ResourceNotFoundException {
		
		Product product = pr.findById(id).orElseThrow(()->new ResourceNotFoundException("Cannot find this is : "+id));
		
				return ResponseEntity.ok().body(product);
		
		
	}
	@DeleteMapping("/products/{id}")
	
	public void deleteProduct(@PathVariable int id) {
		
		pr.deleteById(id);
	}
	@PostMapping ("/products")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		
		Product product1 = pr.save(product);
		
		URI location = 
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(product1.getProductId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateStudent(@RequestBody Product product, @PathVariable int id)
	throws ResourceNotFoundException{

	       Product product1 = pr.findById(id)
	    	        .orElseThrow(() -> 
	    	        new ResourceNotFoundException("Student not found for this id :: " + id));


		product1.setProductId(id);
		product1.setProductName(product.getProductName());
		product1.setPrice(product.getPrice());
		product1.setQty(product.getQty());


		return ResponseEntity.ok(product);
	}
}

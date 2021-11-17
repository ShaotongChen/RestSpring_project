package com.cogent.productmanagementthyme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.productmanagementthyme.dto.Product;
import com.cogent.productmanagementthyme.dto.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository pr;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list= pr.findAll();
		return list;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		pr.save(product);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> p=pr.findById(id);
		Product product = null;
		if(p.isPresent()!=false) {
			product = p.get();
		}else new Exception("cannot find the product by this ID "+ id);
	return product;
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

}

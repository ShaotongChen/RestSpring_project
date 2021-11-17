package com.cogent.productmanagementthyme.service;

import java.util.List;

import com.cogent.productmanagementthyme.dto.Product;

public interface ProductService {
    List < Product > getAllProducts();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
}

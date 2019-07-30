package com.example.service;

import java.util.List;

import com.example.domain.Product;

public interface ProductService {
	
    public List <Product> getProduct();
    public void saveProduct(Product product);
    public Product getProduct(int id);
    public void deleteProduct(int id);
	
}

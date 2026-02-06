package com.example.ProductService.services;

import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(Long productId);
    public List<Product> getProducts();
    public Product createProduct(Product product);
    public Product replaceProduct(Long productId, Product product);
}

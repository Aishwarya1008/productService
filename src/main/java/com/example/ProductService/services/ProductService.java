package com.example.ProductService.services;

import com.example.ProductService.expections.NotFoundException;
import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(Long productId) throws NotFoundException;
    public List<Product> getProducts();
    public Product createProduct(Product product) throws NotFoundException;
    public Product replaceProduct(Long productId, Product product);
}

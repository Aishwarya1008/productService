package com.example.ProductService.controllers;

import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getProduct(productId);
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        return "Deleted Successfully !!";
    }

}

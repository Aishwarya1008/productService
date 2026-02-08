package com.example.ProductService.controllers;

import com.example.ProductService.expections.NotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("realProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(
                product,
                HttpStatus.OK
        );
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) throws NotFoundException {
        return productService.createProduct(product);
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

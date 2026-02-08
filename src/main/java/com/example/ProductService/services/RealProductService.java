package com.example.ProductService.services;

import com.example.ProductService.expections.NotFoundException;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import com.example.ProductService.projections.ProductsWithTitleAndPrice;
import com.example.ProductService.repositories.CategoryRepository;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("realProductService")
@Primary
public class RealProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public RealProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProduct(Long productId) throws NotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new NotFoundException("ProductId " + productId + " does not exists !!");
        }
        return product.get();
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws NotFoundException {
        if(product.getId() != null){
            Optional<Product> optionalProduct = productRepository.findById(product.getId());
            if(optionalProduct.isEmpty()){
                throw new NotFoundException("ProductId " + product.getId() + " is invalid !!");
            }
        }
        if(product.getCategory().getTitle() != null){
            Optional<Category> optionalCategory = categoryRepository.findByTitle(product.getCategory().getTitle());
            if(optionalCategory.isEmpty()){
                Category savedCategory = categoryRepository.save(product.getCategory());
                product.setCategory(savedCategory);
            } else {
                product.setCategory(optionalCategory.get());
            }
        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}

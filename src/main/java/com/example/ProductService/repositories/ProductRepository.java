package com.example.ProductService.repositories;

import com.example.ProductService.models.Product;
import com.example.ProductService.projections.ProductsWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long Id);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long Id);

    @Override
    Product save(Product product);

    @Query(value = "select p.title, p.price from products p where p.price>1000", nativeQuery = true)
    List<ProductsWithTitleAndPrice> findTitleAndPrice();
}

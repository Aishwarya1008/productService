package com.example.ProductService;

import com.example.ProductService.projections.ProductsWithTitleAndPrice;
import com.example.ProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void productsWithPriceAndTitle() {
		List<ProductsWithTitleAndPrice> productsWithTitleAndPriceList = productRepository.findTitleAndPrice();
		for(ProductsWithTitleAndPrice p: productsWithTitleAndPriceList){
			System.out.println(p.getTitle() + " " + p.getPrice());
		}
	}
}

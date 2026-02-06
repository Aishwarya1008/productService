package com.example.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel{

    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

}

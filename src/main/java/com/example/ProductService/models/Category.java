package com.example.ProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "categories")
public class Category extends BaseModel {

    private String title;

}

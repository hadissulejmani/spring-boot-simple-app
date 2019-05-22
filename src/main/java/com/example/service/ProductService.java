package com.example.service;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ProductService {
    Product addNewProduct(Product p);
    List<Product> getAllProducts();
    Product getById(Long productId);
    List<Product> findAll(Category cat);
    List<Product> findAll(Category cat, Manufacturer man);
    Double calcPriceByCategory(Category category);
}

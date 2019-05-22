package com.example.service.impl;

import com.example.models.Product;
import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
	private ProductRepository repo;


    public ProductServiceImpl(ProductRepository repo){
        this.repo = repo;
    }

    @Override
    public Product addNewProduct(Product p) {
        return repo.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    @Override
    public List<Product> findAll(Category cat){
        return repo.findByCategory(cat);
    }

    @Override
    public Product getById(Long productId) {
        return repo.findById(productId).get();
    }

    @Override
    public List<Product> findAll(Category cat, Manufacturer man){
        return repo.findByCategoryAndManufacturer(cat, man);
    }

    @Override
    public Double calcPriceByCategory(Category cat){
        return repo.calcPrice(cat);
    }

}

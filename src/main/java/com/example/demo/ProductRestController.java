package com.example.demo;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;
import com.example.service.CategoryService;
import com.example.service.ManufacturerService;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private ProductService productService;

    private CategoryService categoryService;

    private ManufacturerService manufacturerService;

    public ProductRestController(ProductService service, CategoryService categoryService, ManufacturerService manufacturerService){
        this.productService = service;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("/product/category/{categoryId}")
    public List<Product> getProductByCat(@PathVariable Long categoryId){
        Optional<Category> c = categoryService.findByIdCat(categoryId);
        return productService.findAll(c.get());
    }

    @GetMapping("/product/category/{categoryId}/manufacturer/{manufacturerId}")
    public List<Product> getProductsByCatAndMan(@PathVariable Long categoryId, @PathVariable Long manufacturerId){
        Optional<Category> c = categoryService.findByIdCat(categoryId);
        Optional<Manufacturer> m = manufacturerService.findByManID(manufacturerId);
        return productService.findAll(c.get(), m.get());
    }
    @GetMapping("/product/category/{categoryId}/price")
    public Double calcPrice(@PathVariable Long categoryId){
        Optional<Category> c = categoryService.findByIdCat(categoryId);
        return productService.calcPriceByCategory(c.get());
    }

}

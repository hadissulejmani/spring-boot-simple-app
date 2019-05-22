package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.ManufacturerNotFoundException;

import javax.annotation.PostConstruct;

import com.example.service.CategoryService;
import com.example.service.ManufacturerService;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductController {

	private Long counter;
    private List<Product> productList = null;

    private List<Manufacturer>  manufacturers = new ArrayList<>();
    private List<Category> categories = null;

    private ProductService productService;

    private CategoryService categoryService;

    private ManufacturerService manufacturerService;

    public ProductController(ProductService service, CategoryService categoryService, ManufacturerService manufacturerService){
        this.productService = service;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/products")
    public String productsAll(Model model) {
        model.addAttribute("productsList", productService.getAllProducts());
        return "products";
    }
    
    @GetMapping("/product/{id}")
    public String singleProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.getById(id));
        return "single-product";
    }
    
    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("manufacturerList", manufacturerService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("newProduct", new Product());
        return "product-add";
    }
    
    @ExceptionHandler({ManufacturerNotFoundException.class})
    @PostMapping("/products/add")
    public String addDeviceWithModelAttribute(@ModelAttribute Product p,
                                              @RequestParam("category.id") Long categoryId,
                                              @RequestParam("manufacturer.id") Long manufacturerId) throws IOException {

        Optional<Manufacturer> m = manufacturerService.findByManID(p.getManufacturer().getId());;
        Optional<Category> c = categoryService.findByIdCat(p.getCategory().getId());

        p.setManufacturer(m.get());
        p.setCategory(c.get());

        productService.addNewProduct(p);
        
        return "redirect:/products";
    }

    private Long getNextId() {
        return counter++;
    }
}
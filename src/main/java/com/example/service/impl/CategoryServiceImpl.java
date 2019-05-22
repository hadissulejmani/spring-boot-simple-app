package com.example.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo){
        this.repo = repo;
    }


    @Override
    public List<Category> getAll(){
        return repo.findAll();
    };

    @Override
    public Optional<Category> findByIdCat(Long catId) {
        return repo.findById(catId);
    }
}

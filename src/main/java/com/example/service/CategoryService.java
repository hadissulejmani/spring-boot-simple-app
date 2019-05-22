package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.Category;

public interface CategoryService {
    Optional<Category> findByIdCat(Long catId);
    List<Category> getAll();
}

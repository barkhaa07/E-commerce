package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.repository.CategoryRepository;

// The business logic lives here.
// It calls methods from CategoryRepository and decides how data should be processed or validated.
// For example, it could check for duplicate category names before saving.

@Service  // Routing request through service layer
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

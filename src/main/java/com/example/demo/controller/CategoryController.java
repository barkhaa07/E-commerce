package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;

// This class handles HTTP requests from the client side (like from a browser or mobile app).
// It maps URLs to functions using annotations like @GetMapping, @PostMapping, etc.
// Think of it as the gatekeeper that decides how to respond to each kind of request.

@RestController
@RequestMapping ("/api/categories")
@CrossOrigin(origins = "http://localhost:5173/")
public class CategoryController {

   
    private final CategoryService categoryService;  //Use of Final keyoword - The reference to categoryService cannot be changed after it is initialized.
                                                    //It's a common practice in Spring to mark dependencies as final to indicate they are required and should not change.

    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAllCategory()
    {
        return categoryService.getAllCategories();
    }
}

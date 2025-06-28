package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping ("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {

   private final ProductService productService;

   public ProductController(ProductService productService)
   {
       this.productService = productService;
   }

   @GetMapping
   public List<Product> getAllProducts()
   {
        return productService.getAllProducts();
   }

   @GetMapping ("/Category/{CategoryId}")
   public List<Product> getProductbyCategory(@PathVariable Long CategoryId)
   {
        return productService.getProductbyCategory(CategoryId);
   }
}

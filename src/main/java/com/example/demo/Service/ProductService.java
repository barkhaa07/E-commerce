package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public List<Product> getProductbyCategory(Long CategoryId)
    {
        return productRepository.findByCategoryId(CategoryId);
    }
}

package com.example.demo.config;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

// Data Seeder class needed to populate database with initial or sample data when application starts.
@Component
public class DataSeeder implements CommandLineRunner {  //CommandLineRunner helps us run a particular piece of code

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {

        // clear all repository
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //Create Repository
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home & Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));

        //Create Products
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model SmartPhone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Warm and cozy winter wear jacket");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(299.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High speed blender for smoothies n=and shakes");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(99.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));


    }
      
}

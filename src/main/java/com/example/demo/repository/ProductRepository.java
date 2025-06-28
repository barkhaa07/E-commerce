package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Product;
import java.util.List;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

    List<Product>  findByCategoryId(Long CategoryId); // Naming convention by JPA find-by-categoryId ( clause)
  
}

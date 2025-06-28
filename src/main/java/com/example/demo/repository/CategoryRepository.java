package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Category;

// This acts as a direct bridge to your database.
// It usually extends JpaRepository or CrudRepository, giving you methods like save(), findById(), findAll(), etc.
// Essentially, it’s the layer that talks to your database, using Java objects.

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}

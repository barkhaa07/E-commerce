package com.example.demo.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Data;

@Entity // Marks a class as a JPA entity, meaning it maps to a table in a relational database.
@Data   // Automatically generates boilerplate code like getters, setters, toString(), equals(),
public class Product {

    @Id // Marks the field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells JPA to automatically generate the value of the primary key.
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    @ManyToOne  //Indicates that many instances of the current entity (e.g., Product) are associated with one instance of another entity (e.g., Category).
    @JoinColumn(name = "category_id", nullable = false)  // Specifies the foreign key column in the current entity's table that links to the primary key of the related entity.
    private Category category; 


}

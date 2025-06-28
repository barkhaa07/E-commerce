package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // MappedBy - This tells JPA that the other side of the relationship (the Product entity) owns the relationship.
    // "category" refers to the field in the Product class that maps back to the Category.

    // cascade = CascadeType.ALL
    // This means that all operations (like persist, merge, remove, refresh, detach) performed on the parent (Category) will also be cascaded to the child entities (Product).
    // So if you delete a Category, all its associated Products will also be deleted.

    // fetch = FetchType.LAZY
    // This controls how data is loaded from the database.
    // LAZY: The related entities (Products) are not loaded immediately with the Category. They are loaded only when accessed.
    // This improves performance by avoiding unnecessary data loading.

    @OneToMany (mappedBy = "category",
                    cascade = CascadeType.ALL,
                    fetch = FetchType.LAZY)
    private Set<Product> product;
}

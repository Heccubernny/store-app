package com.mama.pride.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.mama.pride.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    // Additional custom methods for Category
    // ...

    // Example: Get all categories with a given name

    // Category save(@NonNull Category category); // This method is inherited from
    // JpaRepository

    Category findById(int id);

    @NonNull
    List<Category> findAll();

    Category findByName(String name);

    void deleteById(int id);

    // @Modifying
    // @Transactional
    // @Query("UPDATE Category c SET c.name = :name WHERE c.id = :id")
    // void updateCategoryName(@Param("id") Long id, @Param("name") String name);

}

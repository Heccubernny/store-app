package com.mama.pride.repository;

import org.springframework.stereotype.Repository;

import com.mama.pride.entities.Category;

@Repository
public interface CategoryRepository {
    // CRUD operations for Category
    void create(Category category);

    Category read(int id);

    // void update(Category category);

    void delete(Category category);

}

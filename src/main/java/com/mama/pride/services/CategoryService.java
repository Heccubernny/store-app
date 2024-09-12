package com.mama.pride.services;

import java.util.List;

import com.mama.pride.entities.Category;

public interface CategoryService {
    Category findById(int id);

    Category findByName(String name);

    List<Category> findAll();

    Category saveCategory(Category category);

    Category save(Category category);

    void delete(Category category);

    void deleteById(int id);

}

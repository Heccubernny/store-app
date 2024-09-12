package com.mama.pride.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mama.pride.dao.CategoryDao;
import com.mama.pride.entities.Category;

@Service
@Transactional
public class CategoryServiceImplement implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category findById(int id) {
        Optional<Category> category_id = Optional.of(categoryDao.findById(id));
        return category_id.isPresent() ? category_id.get() : null;
    }

    @Override
    public Category findByName(String name) {
        Category getName = categoryDao.findByName(name);
        if (name != null) {
            return getName;
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category save(Category category) {
        Category savedCategory = categoryDao.save(category);
        return savedCategory;
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void deleteById(int id) {
        categoryDao.deleteById(id);
    }

}

package com.mama.pride.repository;

import java.util.List;

import com.mama.pride.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CategoryRepositoryImplement implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Category category) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Category category) {
        // TODO Auto-generated method stub

    }

    @Override
    public Category read(int id) {
        // read all categories that is fruit
        String jpql = "SELECT * FROM Categories c WHERE c.name = :name";
        TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
        List<Category> name = query.getResultList();
        return name.stream().filter(c -> c.getCategoryId() == id).findFirst().orElse(null);
    }
}

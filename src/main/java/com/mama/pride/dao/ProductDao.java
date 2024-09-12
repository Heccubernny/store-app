package com.mama.pride.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mama.pride.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
    @SuppressWarnings({ "unchecked", "null" })
    Product save(Product product);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

}

package com.mama.pride.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mama.pride.entities.Review;

public interface ReviewDao extends JpaRepository<Review, Integer> {
    // @Query("SELECT AVG(star) FROM Review WHERE product_id=(:productId) GROUP BY
    // product_id")

    // Double getAverageStar(@Param("productId") int productId);

    @SuppressWarnings({ "unchecked", "null" })
    Review save(Review review);
}

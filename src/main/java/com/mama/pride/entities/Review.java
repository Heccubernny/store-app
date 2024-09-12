package com.mama.pride.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue
    private int reviewId;

    private String description;

    @Column(name = "userId")
    private int userId;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private int star;

    /**
     * @return the star
     */
    public int getStar() {
        return star;
    }

    /**
     * @param star the star to set
     */
    public void setStar(int star) {
        this.star = star;
    }

    @Column(name = "product_id")
    private int productId;

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "category_id")
    private int categoryId;

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Review(String description, int star, int productId, int categoryId) {
        super();
        this.description = description;
        this.star = star;
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public Review() {

    }
}

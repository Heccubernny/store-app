package com.mama.pride.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int categoryId;

    @Column(name = "name")
    private String name;
    @Column(name = "details")
    private String details;

    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Category() {
        this.productList = new ArrayList<Product>();
    }

    public Category(int categoryId, String name, String details, Date createdAt, List<Product> productList) {
        this.categoryId = categoryId;
        this.name = name;
        this.details = details;
        this.createdAt = createdAt;
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", details=" + details + ", createdAt="
                + createdAt
                + ", productList=" + productList + "]";
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}

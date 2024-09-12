package com.mama.pride.dto;

public class CategoryDto {
    String name;

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

    String details;

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

    public CategoryDto(String name, String details) {
        this.name = name;
        this.details = details;
    }

    @Override
    public String toString() {
        return "CategoryDto [name=" + name + ", details=" + details + ", getName()=" + getName() + ", getDetails()="
                + getDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

}

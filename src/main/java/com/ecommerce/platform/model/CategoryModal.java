package com.ecommerce.platform.model;

public class CategoryModal {
    private Long categoryId;
    private String name;

    public CategoryModal(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

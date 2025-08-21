package com.ecommerce.platform.service;

import com.ecommerce.platform.model.CategoryModal;
import com.ecommerce.platform.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private Long uniqueId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryModal> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(CategoryModal category) {
        category.setCategoryId(uniqueId++);
        categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }
    }

    @Override
    public ResponseEntity<String> updateCategory(CategoryModal category, Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(found -> {
                    found.setName(category.getName());
                    categoryRepository.save(found); // persist the changes
                    return ResponseEntity.status(HttpStatus.OK)
                            .body("Category Updated Successfully");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Category Not Found"));
    }
}

package com.ecommerce.platform.service;

import com.ecommerce.platform.model.CategoryModal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private Long uniqueId = 1L;
    List<CategoryModal> categories = new ArrayList<>();

    @Override
    public List<CategoryModal> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(CategoryModal category) {
        category.setCategoryId(uniqueId++);
        categories.add(category);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long categoryId) {
        boolean result = categories.removeIf(categoryModal -> categoryModal.getCategoryId().equals(categoryId));
        System.out.println(result);

        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }
    }

    @Override
    public ResponseEntity<String> updateCategory(CategoryModal category, Long categoryId) {
        CategoryModal found = null;
        for(CategoryModal c:categories ){
            if(c.getCategoryId().equals(categoryId)){
                found = c;
                break;
            }

        }
        if(found != null){
            found.setName(category.getName());
            return ResponseEntity.status(HttpStatus.OK).body("Category Updated Successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }

    }
}

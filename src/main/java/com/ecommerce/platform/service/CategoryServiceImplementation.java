package com.ecommerce.platform.service;

import com.ecommerce.platform.model.CategoryModal;
import org.springframework.stereotype.Service;

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
    public String  deleteCategory(Long categoryId) {
        boolean result = categories.removeIf(categoryModal -> categoryModal.getCategoryId().equals( categoryId));
        System.out.println(result);
        if(result){
            return "Deleted Successfully";
        }
        else{
            return "Category Not Found";
        }

    }
}

package com.ecommerce.platform.controller;

import com.ecommerce.platform.model.CategoryModal;
import com.ecommerce.platform.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
   public List<CategoryModal> getAllCategories(){
       return categoryService.getAllCategories();
   }

   @PostMapping("/api/admin/category")
    public String createCategory(@RequestBody CategoryModal category){
       categoryService.createCategory(category);
       return "Category Added Successfully";
   }

   @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
       return categoryService.deleteCategory(categoryId);

   }
}

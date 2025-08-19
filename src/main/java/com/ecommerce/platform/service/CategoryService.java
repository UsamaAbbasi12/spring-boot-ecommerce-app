package com.ecommerce.platform.service;

import com.ecommerce.platform.model.CategoryModal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface CategoryService {

     List<CategoryModal>  getAllCategories();
     void createCategory(CategoryModal category);
     ResponseEntity<String> deleteCategory(Long categoryId);
     ResponseEntity<String> updateCategory(CategoryModal category, Long categoryId);

}

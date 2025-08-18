package com.ecommerce.platform.service;

import com.ecommerce.platform.model.CategoryModal;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface CategoryService {

     List<CategoryModal>  getAllCategories();
     void createCategory(CategoryModal category);
     String deleteCategory(Long categoryId);

}

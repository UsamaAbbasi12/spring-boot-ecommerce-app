package com.ecommerce.platform.repositories;

import com.ecommerce.platform.model.CategoryModal;
import org.springframework.data.jpa.repository.JpaRepository;

//Two Arguments are what types of data or modal we are using and the second is type of Primary Key
public interface CategoryRepository extends JpaRepository<CategoryModal, Long> {

}

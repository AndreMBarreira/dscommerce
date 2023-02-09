package com.devsuperior.dscommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query("SELECT obj FROM Category obj JOIN FETCH obj.products")
	List<Category> findCategoryWithProducts();
}

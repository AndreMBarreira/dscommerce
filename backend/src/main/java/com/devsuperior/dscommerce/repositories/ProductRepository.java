package com.devsuperior.dscommerce.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(nativeQuery = true, value = 
			"SELECT * "
			+ "FROM tb_product ")
	Page<Product> search1(Pageable pageable);
	
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories")
	List<Product> findProductWithCategories();
	
	
}

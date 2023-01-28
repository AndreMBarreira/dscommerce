package com.devsuperior.dscommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		
		ProductDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	/*@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		
		List<ProductDTO> dto = service.findAll();
		
		return ResponseEntity.ok().body(dto);
	}*/
	
	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAllPage(Pageable pageable){
		
		Page<ProductDTO> dto = service.findAllPage(pageable);
		
		return ResponseEntity.ok().body(dto);
	}

}

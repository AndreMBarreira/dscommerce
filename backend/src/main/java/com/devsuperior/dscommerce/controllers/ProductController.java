package com.devsuperior.dscommerce.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;

import jakarta.validation.Valid;

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
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		
		List<ProductDTO> dto = service.findAll();
		
		return ResponseEntity.ok().body(dto);
	}
	
	/*@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAllPage(Pageable pageable){
		
		Page<ProductDTO> dto = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(dto);
	}*/
	
	/*@PostMapping
	public ProductDTO insert(@RequestBody ProductDTO dto){

		return service.insert(dto);
	}*/
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

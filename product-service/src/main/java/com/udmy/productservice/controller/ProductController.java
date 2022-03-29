package com.udmy.productservice.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udmy.productservice.dto.ProductDto;
import com.udmy.productservice.service.IProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private IProductService service;

	@GetMapping("all")
	public Flux<ProductDto> getAllProducts() {
		return this.service.getAllProducts();
	}

	@GetMapping("price-range")
	public Flux<ProductDto> getByPriceRange(@RequestParam("min") int min, @RequestParam("max") int max) {
		return this.service.getProductsByPriceRange(min, max);
	}

	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getProduct(@PathVariable String id) {
		//for creating  intermittent issue
		//this.simulateRandomException();
		return this.service.getProductById(id)
		        .map(ResponseEntity::ok)
		        .defaultIfEmpty(ResponseEntity.notFound()
		                .build());
	}

	@PostMapping("insert")
	public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> mono) {
		return this.service.insertProduct(mono);
	}

	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDto> mono) {
		return this.service.updateProduct(id, mono)
		        .map(ResponseEntity::ok)
		        .defaultIfEmpty(ResponseEntity.notFound()
		                .build());
	}

	@DeleteMapping("{id}")
	public Mono<Void> deleteProduct(@PathVariable String id) {
		return this.service.delete(id);
	}

	@SuppressWarnings("unused")
	private void simulateRandomException() {
		int nextInt = ThreadLocalRandom.current()
		        .nextInt(1, 10);
		if (nextInt > 5)
			throw new RuntimeException("Something worng");
	}

}

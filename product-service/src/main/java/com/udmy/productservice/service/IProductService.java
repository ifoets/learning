package com.udmy.productservice.service;

import org.springframework.stereotype.Service;

import com.udmy.productservice.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("productService")
public interface IProductService {

	public Flux<ProductDto> getAllProducts();

	public Flux<ProductDto> getProductsByPriceRange(int min, int max);

	public Mono<ProductDto> getProductById(String id);

	public Mono<ProductDto> insertProduct(Mono<ProductDto> mono);

	public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> mono);

	public Mono<Void> delete(String id);

}

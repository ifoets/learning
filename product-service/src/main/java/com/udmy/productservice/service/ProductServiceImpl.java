package com.udmy.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.udmy.productservice.dto.ProductDto;
import com.udmy.productservice.repository.ProductRepository;
import com.udmy.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Flux<ProductDto> getAllProducts() {
		return this.repository.findAll()
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Flux<ProductDto> getProductsByPriceRange(int min, int max) {
		return this.repository.findByPriceBetween(Range.closed(min, max))
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<ProductDto> getProductById(String id) {
		return this.repository.findById(id)
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<ProductDto> insertProduct(Mono<ProductDto> mono) {
		return mono.map(EntityDtoUtil::toEntity)
		        .flatMap(this.repository::insert)
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> mono) {
		return this.repository.findById(id)
		        .flatMap(p -> mono.map(EntityDtoUtil::toEntity)
		                .doOnNext(e -> e.setId(id)))
		        .flatMap(this.repository::save)
		        .map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> delete(String id) {
		return this.repository.deleteById(id);
	}

}

package com.udmy.productservice.service;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.udmy.productservice.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataSetupService implements CommandLineRunner {

	@Autowired
	private IProductService iProductService;

	@Override
	public void run(String... args) throws Exception {
		ProductDto p1 = new ProductDto("TVS Bike", 1500);
		ProductDto p2 = new ProductDto("SLR Camara", 750);
		ProductDto p3 = new ProductDto("Apple Mac", 2000);
		ProductDto p4 = new ProductDto("iphone ", 800);
		ProductDto p5 = new ProductDto("headphone ", 200);

		Flux.just(p1, p2, p3, p4, p5)
		        // this is for sink testing
		        // .concatWith(newProducts())
		        .flatMap(e -> iProductService.insertProduct(Mono.just(e)))
		        .subscribe(System.out::println);

	}

	@SuppressWarnings("unused")
	private Flux<ProductDto> newProducts() {
		return Flux.range(1, 1000)
		        .delayElements(Duration.ofSeconds(2))
		        .map(i -> new ProductDto("Product-" + i, ThreadLocalRandom.current()
		                .nextInt(10, 100)));
	}
}

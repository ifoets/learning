package com.udmy.productservice.util;

import org.springframework.beans.BeanUtils;

import com.udmy.productservice.dto.ProductDto;
import com.udmy.productservice.entity.Product;

public class EntityDtoUtil {

	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);
		return dto;
	}

	public static Product toEntity(ProductDto dto) {
		Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		return product;
	}
}

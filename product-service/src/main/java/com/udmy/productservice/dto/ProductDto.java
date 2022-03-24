package com.udmy.productservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Builder
public class ProductDto {

	private String id;
	private String description;
	private Integer price;

	public ProductDto() {
		super();
	}

	public ProductDto(String description, Integer price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", description=" + description + ", price=" + price + "]";
	}

}

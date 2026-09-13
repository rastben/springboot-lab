package com.rubenvelandia.springboot_lab.mapper;

import com.rubenvelandia.springboot_lab.dto.ProductDto;
import com.rubenvelandia.springboot_lab.entity.Product;

public final class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductDto dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }
}
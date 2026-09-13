package com.rubenvelandia.springboot_lab.service;

import java.util.List;
import java.util.Optional;

import com.rubenvelandia.springboot_lab.dto.ProductDto;
import com.rubenvelandia.springboot_lab.entity.Product;

public interface ProductService {
    
    List<ProductDto> findAll();

    Optional<ProductDto> findById(Long id);

    ProductDto save(Product product);

    ProductDto update(Long id, Product product);

    void delete(Long id);
}

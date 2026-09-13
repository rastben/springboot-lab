package com.rubenvelandia.springboot_lab.service;

import com.rubenvelandia.springboot_lab.dto.ProductDto;
import com.rubenvelandia.springboot_lab.entity.Product;
import com.rubenvelandia.springboot_lab.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream()
            .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
            .toList();
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return repository.findById(id).map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()));
    }

    @Override
    public ProductDto save(Product product) {
        Product p = repository.save(product);
        return new ProductDto(p.getId(), p.getName(), p.getPrice());
    }

    @Override
    public ProductDto update(Long id, Product product) {

        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        Product p = repository.save(product);
        return new ProductDto(p.getId(), p.getName(), p.getPrice());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
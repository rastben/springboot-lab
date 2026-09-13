package com.rubenvelandia.springboot_lab.controller;

import com.rubenvelandia.springboot_lab.dto.ProductDto;
import com.rubenvelandia.springboot_lab.entity.Product;
import com.rubenvelandia.springboot_lab.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Comentario para modificar jar y crear nuevamente imagen docker
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {

        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDto create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id,
                          @RequestBody Product product) {

        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
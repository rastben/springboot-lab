package com.rubenvelandia.springboot_lab.repository;

import com.rubenvelandia.springboot_lab.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

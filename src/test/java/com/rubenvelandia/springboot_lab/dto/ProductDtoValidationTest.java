package com.rubenvelandia.springboot_lab.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductDtoValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    static void tearDown() {
        validatorFactory.close();
    }

    @Test
    void shouldRejectBlankProductName() {
        ProductDto product = new ProductDto(1L, "", 100.0);

        Set<ConstraintViolation<ProductDto>> violations =
                validator.validate(product);

        assertEquals(1, violations.size());
        assertTrue(
                violations.stream()
                        .anyMatch(violation ->
                                violation.getPropertyPath()
                                        .toString()
                                        .equals("name"))
        );
    }

    @Test
    void shouldRejectNonPositiveProductPrice() {
        ProductDto product = new ProductDto(1L, "Laptop", 0.0);

        Set<ConstraintViolation<ProductDto>> violations =
                validator.validate(product);

        assertEquals(1, violations.size());
        assertTrue(
                violations.stream()
                        .anyMatch(violation ->
                                violation.getPropertyPath()
                                        .toString()
                                        .equals("price"))
        );
    }

    @Test
    void shouldAcceptValidProduct() {
        ProductDto product = new ProductDto(1L, "Laptop", 100.0);

        Set<ConstraintViolation<ProductDto>> violations =
                validator.validate(product);

        assertTrue(violations.isEmpty());
    }
}
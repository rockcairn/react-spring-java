package com.rockcairn.estore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockcairn.estore.dto.ProductDto;
import com.rockcairn.estore.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productService;

    public ProductsController(ProductsService productService) {
        this.productService = productService;
    }

     
    @GetMapping("/{id}")
    public ProductDto getPeak(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {

        // Map back to DTOs
        ProductDto response = productService.createProduct(dto);

        // Return 201 Created with resource body
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

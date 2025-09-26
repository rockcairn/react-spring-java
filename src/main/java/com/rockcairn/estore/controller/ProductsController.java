package com.rockcairn.estore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}

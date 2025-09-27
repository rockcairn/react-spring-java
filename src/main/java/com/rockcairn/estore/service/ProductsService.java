package com.rockcairn.estore.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rockcairn.estore.dto.ProductDto;
import com.rockcairn.estore.entity.Product;
import com.rockcairn.estore.mapper.ProductMapper;
import com.rockcairn.estore.repository.ProductsRepository;

@Service
public class ProductsService {

    private final ProductsRepository productRepository;
    private final ProductMapper productMapper;

    public ProductsService(ProductsRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto getProductById(Long id) {
        // product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not found"));
        
        Product product = productRepository.findById(id).orElse( new Product());
        return productMapper.toDto(product);
    }

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();

        logRepositoryResponse(products);

        return productMapper.toDtoList(products);
    }

    public ProductDto createProduct(ProductDto dto) {
        logRepositoryResponse(dto);
        // Convert DTO → entity
        Product entity = productMapper.toEntity(dto);

        // Save to DB
        Product saved = productRepository.save(entity);

        // Map back to DTO
        ProductDto response = productMapper.toDto(saved);

        return response;
    }

    private void logRepositoryResponse(Object data) {
        try {
            String json;
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            json = mapper.writeValueAsString(data);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

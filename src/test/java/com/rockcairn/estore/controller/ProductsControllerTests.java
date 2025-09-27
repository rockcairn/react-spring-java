package com.rockcairn.estore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rockcairn.estore.dto.ProductDto;
import com.rockcairn.estore.service.ProductsService;

@WebMvcTest(ProductsController.class)
public class ProductsControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductsService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProducts() throws Exception {

        ProductDto dto = new ProductDto();
        dto.setId(1L);
        dto.setName("Tent");

        Mockito.when(productService.getProducts()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Tent"));
    }

    @Test
    void testCreateProduct() throws Exception {
        ProductDto inputDto = new ProductDto();
        inputDto.setName("Backpack");

        ProductDto outputDto = new ProductDto();
        outputDto.setId(2L);
        outputDto.setName("Backpack");

        Mockito.when(productService.createProduct(inputDto)).thenReturn(outputDto);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2))

                .andExpect(jsonPath("$.name").value("Backpack"));
    }
}

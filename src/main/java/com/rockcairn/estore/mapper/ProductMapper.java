package com.rockcairn.estore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.rockcairn.estore.dto.ProductDto;
import com.rockcairn.estore.entity.Product;

@Mapper(componentModel = "spring") // tells MapStruct to make it a Spring bean
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);

    List<ProductDto> toDtoList(List<Product> products);

}

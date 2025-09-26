package com.rockcairn.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockcairn.estore.entity.Product;

@Repository
public interface ProductsRepository  extends JpaRepository<Product, Long> {
    
}

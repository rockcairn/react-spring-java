package com.rockcairn.estore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    // @Column(precision = 10, scale = 2, nullable = false)
    // private BigDecimal price;


    public long getId(){
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}

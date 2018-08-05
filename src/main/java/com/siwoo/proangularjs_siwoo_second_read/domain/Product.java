package com.siwoo.proangularjs_siwoo_second_read.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter @ToString
public class Product {

    public enum Category {
        Soccer, WaterSports, Chess
    }

    private Long id;
    private String name;
    private String description;
    private Category category;
    private double price;

    public Product(String name, String description, Category category, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }
}

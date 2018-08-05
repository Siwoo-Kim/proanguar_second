package com.siwoo.proangularjs_siwoo_second_read.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class Order {

    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private boolean giftwrap;
    private List<Product> products = new ArrayList<>();

}

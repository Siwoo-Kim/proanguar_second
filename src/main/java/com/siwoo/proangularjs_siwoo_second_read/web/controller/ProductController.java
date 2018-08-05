package com.siwoo.proangularjs_siwoo_second_read.web.controller;

import com.siwoo.proangularjs_siwoo_second_read.domain.Order;
import com.siwoo.proangularjs_siwoo_second_read.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final List<Product> products = Collections.synchronizedList(new ArrayList<>());
    private static final List<Order> orders = Collections.synchronizedList(new ArrayList<>());
    private static long idTracker = 0;
    private static long idOrderTracker = 0;

    synchronized static private long nextId() {
        return ++idTracker;
    }
    synchronized static private long nextOrderId() {
        return ++idOrderTracker;
    }

    static {
        Product product = new Product("Kayak", "1인용 보트", Product.Category.WaterSports, 275);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("LifeJacket", "멋진 보호 장비", Product.Category.WaterSports, 48.95);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Soccer Ball", "FIFA 인증 규격 및 무게", Product.Category.Soccer, 19.5);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Corner Flags", "코너 플래그", Product.Category.Soccer, 34.95);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Stadium", "35000좌석 경기장", Product.Category.Soccer, 79500.00);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Thinking cap", "두뇌 효율을 75%로 개선", Product.Category.Chess, 16);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Unsteady Chair", "상대방에게 불리한 체스 의자", Product.Category.Chess, 29.95);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Human Chess Board", "가족이 하기에 즐거운 게임", Product.Category.Chess, 75);
        product.setId(nextId( ));
        products.add(product);
        product = new Product("Bling-Bling King", "금과 다이아몬드로 장식한 게임", Product.Category.Chess, 1200);
        product.setId(nextId());
        products.add(product);
    }

    @GetMapping
    List<Product> products() {
        return products;
    }

    @PostMapping
    Order post(@RequestBody Order order) {
        order.setId(nextOrderId());
        orders.add(order);
        System.out.println("The order is saved: " + order);
        return order;
    }
}

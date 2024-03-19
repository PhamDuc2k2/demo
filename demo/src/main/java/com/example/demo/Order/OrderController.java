package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;


    @PostMapping("/{id}")
    public ResponseEntity createOrder(@PathVariable UUID id) {
        UUID uuid = new UUID();

    }

}

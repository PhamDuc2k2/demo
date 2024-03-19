package com.example.demo.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "total")
    private String total;
}



package com.example.demo.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

//    @OneToOne(mappedBy = "address")
//    private Customer customer;

//    @Column(name = "customer_id")
//    private Integer customerId;

    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore
    private List<Customer> customers;

}

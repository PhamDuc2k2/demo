package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Address> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressRepository.findById(id).get());
    }
}

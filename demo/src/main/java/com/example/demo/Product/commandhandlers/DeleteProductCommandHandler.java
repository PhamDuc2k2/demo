package com.example.demo.Product.commandhandlers;

import com.example.demo.Command;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity execute(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
            throw new ProductNotFoundException();
        productRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}

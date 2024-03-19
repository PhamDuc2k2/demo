package com.example.demo.Product.queryhandlers;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDto;
import com.example.demo.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDto> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDto> execute(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return ResponseEntity.ok(new ProductDto(product.get()));
    }
}

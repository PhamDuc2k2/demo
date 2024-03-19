package com.example.demo.Product.queryhandlers;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDto;
import com.example.demo.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDto>> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<List<ProductDto>> execute(Void input) {
//        List<ProductDto> productDtos = productRepository
//                .findAll()
//                .stream()
//                .map(ProductDto::new)
//                .toList();

        List<ProductDto> productDTOs = productRepository.getAllProductDTOs();

        return ResponseEntity.ok(productDTOs);
    }
}

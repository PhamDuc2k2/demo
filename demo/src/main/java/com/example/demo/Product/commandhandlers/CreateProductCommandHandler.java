package com.example.demo.Product.commandhandlers;

import com.example.demo.Command;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Product.Model.Product;
import com.example.demo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateProductCommandHandler implements Command<Product, ResponseEntity> {
    @Autowired
    private ProductRepository productRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductCommandHandler.class);


    @Override
    public ResponseEntity execute(Product product) {
        LOGGER.info("Đã post thành công");
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    private void validateProduct(Product product) {
        if (StringUtils.isEmpty(product.getName()))
            throw new ProductNotValidException("Product name cannot empty");
        if (StringUtils.isEmpty(product.getDescription()))
            throw new ProductNotValidException("Product description cannot empty");
        if (product.getPrice() <= 0)
            throw new ProductNotValidException("Prodct price cannot negative");
        if (product.getQuantity() < 0)
            throw new ProductNotValidException("Product price cannot negative");
    }
}

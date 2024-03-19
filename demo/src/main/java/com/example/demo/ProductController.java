package com.example.demo;


import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDto;
import com.example.demo.Product.Model.UpdateProductCommand;
import com.example.demo.Product.commandhandlers.CreateProductCommandHandler;
import com.example.demo.Product.commandhandlers.DeleteProductCommandHandler;
import com.example.demo.Product.commandhandlers.UpdateProductCommandHandler;
import com.example.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
//  Create,     Read,   Update, Delete
//  Post,       Get,    Put,    Delete

    @Autowired private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired private ProductRepository productRepository;

    @Autowired private GetProductQueryHandler getProductQueryHandler;

    @Autowired private CreateProductCommandHandler createProductCommandHandler;

    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;

    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;

    @GetMapping("/search/{maxPrice}")
    public ResponseEntity<List<Product>> findProductPrice(@PathVariable Double maxPrice) {
        return ResponseEntity.ok(productRepository.findProductsWithPriceLessThan(maxPrice));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return getAllProductsQueryHandler.execute(null);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(value = "d") String description) {
        return ResponseEntity.ok(productRepository.findByDescriptionContaining(description));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
       return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return createProductCommandHandler.execute(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id){
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(id, product);
        return updateProductCommandHandler.execute(updateProductCommand);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return deleteProductCommandHandler.execute(id);
    }


}



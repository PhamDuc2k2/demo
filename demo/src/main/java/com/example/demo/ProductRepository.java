package com.example.demo;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.price < :maxPrice")
    List<Product> findProductsWithPriceLessThan(@Param("maxPrice") double maxPrice);

    @Query("select new com.example.demo.Product.Model.ProductDto(p.name, p.description, p.price) from Product p")
    List<ProductDto> getAllProductDTOs();

//    SQL query
    @Query("select p from Product  p where p.description like %:description%")
    List<Product> customQueryMethod(@Param("description") String description);


//    Spring Data JPA
    List<Product> findByDescriptionContaining(String keyword);
}

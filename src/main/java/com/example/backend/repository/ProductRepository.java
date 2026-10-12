package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // @Query("select p from Product p where p.price > 300")
    // List<Product> getProducts();

    // @Query("select p from Product p where p.price < :price")
    // List<Product> getProducts(@Param("price") double price);

    // List<Product> findByPriceLessThan(double price);

    //  List<Product> findByPriceLessThanAndNameContaining(double price,String name);

      @Query("select p from Product p where p.price < :price and p.name like %:name%")
    List<Product> getProducts(@Param("price") double price,@Param("name") String name);


}

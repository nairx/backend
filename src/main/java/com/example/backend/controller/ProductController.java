package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
// @CrossOrigin
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(defaultValue = "1000") double price,@RequestParam(defaultValue = "") String name) {
        return productService.getProducts(price,name);
    }


    @GetMapping("/{id}")
    public Optional<Product> geProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

  

}

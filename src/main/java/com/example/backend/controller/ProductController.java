package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> geProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePoduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return true;
    }

    @PutMapping("/update/{id}")
    public Product udpateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}

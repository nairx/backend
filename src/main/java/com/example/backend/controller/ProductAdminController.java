package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
// @CrossOrigin
public class ProductAdminController {

    private final ProductService productService;

    ProductAdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(defaultValue = "1000") double price,@RequestParam(defaultValue = "") String name) {
        return productService.getProducts(price,name);
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

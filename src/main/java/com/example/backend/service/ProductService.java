package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // public List<Product> getProducts() {
    // // return productRepository.findAll();
    // return productRepository.getProducts(300);
    // }

    // public List<Product> getProducts(double price) {
    // // return productRepository.findAll();
    // return productRepository.getProducts(price);
    // }

    public List<Product> getProducts(double price, String name) {
        // return productRepository.findAll();
        // return productRepository.findByPriceLessThan(price);
        // return productRepository.findByPriceLessThanAndNameContaining(price,name);
        return productRepository.getProducts(price, name);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

}

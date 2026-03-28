package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ Save (Add / Update)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // ✅ Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
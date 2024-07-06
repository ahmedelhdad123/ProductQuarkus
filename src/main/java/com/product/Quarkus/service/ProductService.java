package com.product.Quarkus.service;

import com.product.Quarkus.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void deleteById(int id);
    void updateProduct(int id, Product product);

}
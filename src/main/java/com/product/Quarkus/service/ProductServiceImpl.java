package com.product.Quarkus.service;

import com.product.Quarkus.entity.Product;
import com.product.Quarkus.repositories.ProductRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(int id) {
            productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
            productRepo.updateProduct(id,product);
    }
}

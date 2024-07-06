package com.product.Quarkus.repositories;

import com.product.Quarkus.excption.ProductException;
import jakarta.enterprise.context.ApplicationScoped;
import com.product.Quarkus.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductRepoImpl implements ProductRepo {

    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductException("Product not found"));
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void deleteById(int id) {
        Product product = findById(id);
        if (product == null) {
            throw new ProductException("Product not found");
        }
        products.remove(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        Product existProduct = findById(id);
        if (existProduct != null) {
            if (id == existProduct.getId()) {
                products.set(products.indexOf(existProduct), product);
            }
        } else {
            throw new ProductException("Product with id " + id + " not found");
        }
    }
}

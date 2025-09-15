package com.codegym.productmanagerthymeleaf.service;

import com.codegym.productmanagerthymeleaf.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(int id, Product product);

    void delete(int id);

    List<Product> findByName(String keyword);
}

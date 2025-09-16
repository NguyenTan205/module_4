package com.codegym.springuploadfile.service;

import com.codegym.springuploadfile.model.Product;
import com.codegym.springuploadfile.model.ProductForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class IProductServiceImpl implements IProductService {
    private final List<Product> products;

    public IProductServiceImpl() {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
        products.remove(findById(id));
    }

    @Override
    public void update(int id, Product product) {
        int index = products.indexOf(product);
        products.set(index, product);
    }

}

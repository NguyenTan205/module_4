package com.codegym.customer_manger.service;

import com.codegym.customer_manger.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}

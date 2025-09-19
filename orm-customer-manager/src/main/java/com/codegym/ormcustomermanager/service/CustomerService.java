package com.codegym.ormcustomermanager.service;

import com.codegym.ormcustomermanager.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}

package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface ILoginService {
    List<User> findAll();

    void save(User user);

    User findByUsername(String username);
}

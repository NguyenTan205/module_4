package com.codegym.customermanageexceptionhandler.service;

import com.codegym.customermanageexceptionhandler.exception.DuplicateEmailException;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}

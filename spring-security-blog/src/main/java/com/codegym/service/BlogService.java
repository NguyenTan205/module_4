package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContains(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);

    Blog findById(Long id);
}

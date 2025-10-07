package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContains(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContains(title, pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findAllByCategoryId(id, pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}

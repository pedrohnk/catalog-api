package com.dev.catalog.service;

import com.dev.catalog.domain.Category;
import com.dev.catalog.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<Category> perform() {
        return repository.findAll();
    }
}

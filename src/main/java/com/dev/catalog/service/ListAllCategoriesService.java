package com.dev.catalog.service;

import com.dev.catalog.domain.Category;
import com.dev.catalog.interfaces.presenters.dto.CategoryDto;
import com.dev.catalog.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListAllCategoriesService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDto> perform() {
        List<Category> allCategories = repository.findAll();
        return allCategories.stream()
                .map(CategoryDto::new)
                .collect(Collectors.toList());
    }
}
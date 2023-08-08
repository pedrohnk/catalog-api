package com.dev.catalog.service;

import com.dev.catalog.domain.Category;
import com.dev.catalog.domain.exceptions.CategoryNotFoundException;
import com.dev.catalog.interfaces.web.dto.CategoryDto;
import com.dev.catalog.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class FindCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoryDto perform(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.orElseThrow(() -> new CategoryNotFoundException());
        return new CategoryDto(category);
    }
}
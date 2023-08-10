package com.dev.catalog.service;

import com.dev.catalog.entity.Category;
import com.dev.catalog.presenters.dto.CategoryDto;
import com.dev.catalog.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional()
    public CategoryDto perform(CategoryDto dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }
}

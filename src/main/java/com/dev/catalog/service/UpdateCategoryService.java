package com.dev.catalog.service;

import com.dev.catalog.entity.Category;
import com.dev.catalog.entity.exceptions.ResourceNotFoundException;
import com.dev.catalog.presenters.dto.CategoryDto;
import com.dev.catalog.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public CategoryDto perform(Long id, CategoryDto dto) throws EntityNotFoundException {
        try{
            Category category = categoryRepository.getReferenceById(id);
            category.setName(dto.getName());
            category = categoryRepository.save(category);
            return new CategoryDto(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found.");
        }
    }
}

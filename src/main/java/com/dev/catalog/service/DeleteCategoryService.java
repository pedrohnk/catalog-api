package com.dev.catalog.service;

import com.dev.catalog.entity.exceptions.ResourceNotFoundException;
import com.dev.catalog.presenters.exception.DatabaseException;
import com.dev.catalog.repository.CategoryRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void perform(Long id){
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category with ID not found: " + id);
        }

        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Deletion failed due to integrity violation for ID: " + id);
        }
    }
}

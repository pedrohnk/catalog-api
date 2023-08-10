package com.dev.catalog.presenters.controller;

import com.dev.catalog.presenters.dto.CategoryDto;

import com.dev.catalog.service.FindCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class FindCategoryController {
    @Autowired
    private FindCategoryService findCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        CategoryDto category = findCategoryService.perform(id);
        return ResponseEntity.ok(category);
    }
}
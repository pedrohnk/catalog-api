package com.dev.catalog.controller;

import com.dev.catalog.domain.Category;
import com.dev.catalog.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> allCategories = service.perform();
        return ResponseEntity.ok(allCategories);
    }
}

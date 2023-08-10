package com.dev.catalog.presenters.controller;

import com.dev.catalog.presenters.dto.CategoryDto;
import com.dev.catalog.service.UpdateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class UpdateCategoryController {
    @Autowired
    private UpdateCategoryService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto category) {
        category = service.perform(id, category);
        return ResponseEntity.ok().body(category);
    }
}

package com.dev.catalog.presenters.controller;

import com.dev.catalog.presenters.dto.CategoryDto;
import com.dev.catalog.service.CreateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CreateCategoryController {
    @Autowired
    private CreateCategoryService service;

    @PostMapping
    public ResponseEntity<CategoryDto> insert(@RequestBody CategoryDto category){
        category = service.perform(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(uri).body(category);
    }
}

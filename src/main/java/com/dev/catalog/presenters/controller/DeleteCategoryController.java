package com.dev.catalog.presenters.controller;

import com.dev.catalog.service.DeleteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class DeleteCategoryController {
    @Autowired
    private DeleteCategoryService service;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.perform(id);
        return ResponseEntity.noContent().build();
    }
}

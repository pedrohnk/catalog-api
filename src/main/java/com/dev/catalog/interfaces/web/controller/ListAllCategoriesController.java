package com.dev.catalog.interfaces.web.controller;

import com.dev.catalog.interfaces.web.dto.CategoryDto;
import com.dev.catalog.service.ListAllCategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ListAllCategoriesController {
    @Autowired
    private ListAllCategoriesService service;

    @GetMapping
    public List<CategoryDto> listCategories() {
        return service.perform();
    }
}
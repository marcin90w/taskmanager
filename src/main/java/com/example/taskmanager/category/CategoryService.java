package com.example.taskmanager.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    CategoryDtoMapper categoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }
}

package com.example.taskmanager.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryDtoMapper {
    CategoryDto map(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setType(category.getType());
        return dto;
    }
}

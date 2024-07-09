package com.pdk.blog.app.Service;

import com.pdk.blog.app.Payloads.CategoryDto;
import java.util.List;

public interface CategoryService {
    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    void deleteCategory(Integer categoryId);

    // get
    CategoryDto getCategory(Integer categoryId);

    // Get All
    List<CategoryDto> getAllCategory();
}

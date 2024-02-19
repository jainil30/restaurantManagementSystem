package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAllCategories();

    void saveCategory(Category category);

    Category fetchByCategoryId(Long aLong);

    void update(Long aLong, Category category);

    void deleteCategory(Long id);
}

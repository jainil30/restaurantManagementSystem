package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Category;
import com.jainil.restaurantManagementSystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImplementation implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category fetchByCategoryId(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Category category) {
        Category categoryDb = categoryRepository.findById(id).get();

        if(Objects.nonNull(category.getCategoryName()) && !"".equals(category.getCategoryName())){
            categoryDb.setCategoryName(category.getCategoryName());
        }

        if(Objects.nonNull(category.getCategoryDescription()) && !"".equals(category.getCategoryDescription())){
            categoryDb.setCategoryDescription(category.getCategoryDescription());
        }

        categoryRepository.save(categoryDb);
    }

    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }
}

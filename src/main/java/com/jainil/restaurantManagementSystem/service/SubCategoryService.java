package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    List<SubCategory> fetchAllSubCategories();

    void saveSubCategory(SubCategory subCategory);

    SubCategory fetchSubCategoryById(Long id);

    void update(Long id, SubCategory subCategory);

    void deleteSubCategory(Long id);

    List<SubCategory> fetchSubCategoryByCategoryName(String categoryName);
}

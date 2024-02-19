package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.SubCategory;
import com.jainil.restaurantManagementSystem.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubCategoryServiceImplementation implements SubCategoryService{

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> fetchAllSubCategories() {
        return this.subCategoryRepository.findAll();
    }

    @Override
    public void saveSubCategory(SubCategory subCategory) {
        this.subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory fetchSubCategoryById(Long id) {
        return this.subCategoryRepository.findById(id).get();
    }

    @Override
    public void update(Long id, SubCategory subCategory) {
        SubCategory subCategoryDb = subCategoryRepository.findById(id).get();

        if(Objects.nonNull(subCategory.getSubCategoryCategoryName()) && !"".equals(subCategory.getSubCategoryCategoryName())){
            subCategoryDb.setSubCategoryCategoryName(subCategory.getSubCategoryCategoryName());
        }

        if(Objects.nonNull(subCategory.getSubCategoryName()) && !"".equals(subCategory.getSubCategoryName())){
            subCategoryDb.setSubCategoryName(subCategory.getSubCategoryName());
        }

        if(Objects.nonNull(subCategory.getSubCategoryDescription()) && !"".equals(subCategory.getSubCategoryDescription())){
            subCategoryDb.setSubCategoryDescription(subCategory.getSubCategoryDescription());
        }

        subCategoryRepository.save(subCategoryDb);

    }

    @Override
    public void deleteSubCategory(Long id) {
        this.subCategoryRepository.deleteById(id);
    }

    @Override
    public List<SubCategory> fetchSubCategoryByCategoryName(String categoryName) {
        return this.subCategoryRepository.findBySubCategoryCategoryName(categoryName);
    }
}

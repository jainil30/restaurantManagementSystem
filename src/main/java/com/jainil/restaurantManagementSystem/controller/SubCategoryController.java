package com.jainil.restaurantManagementSystem.controller;


import com.jainil.restaurantManagementSystem.entity.SubCategory;
import com.jainil.restaurantManagementSystem.service.SubCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubCategoryController {

    private final Logger LOGGER = LoggerFactory.getLogger(SubCategory.class);
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/subCategory/{categoryName}")
    public List<SubCategory> getSubCategory(@PathVariable String categoryName){
        System.out.println("Category : " + categoryName);
        LOGGER.info("getSbCategory() called");
        return subCategoryService.fetchSubCategoryByCategoryName(categoryName);
    }
}

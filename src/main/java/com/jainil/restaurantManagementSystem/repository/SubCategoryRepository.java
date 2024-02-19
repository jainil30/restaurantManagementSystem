package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findBySubCategoryCategoryName(String categoryName);
}

package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductRestaurant(String email);
}

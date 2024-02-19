package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Product;

import java.util.List;

public interface ProductService {
    Product fetchProductById(Long id);

    List<Product> fetchAllProducts();

    void saveProduct(Product product);

    void updateProduct(Long id, Product product);

    void deleteProduct(Long aLong);

    List<Product> fetchAllProductsByProductRestaurant(String email);
}

package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Restaurant;
import com.jainil.restaurantManagementSystem.entity.Role;

import java.util.List;

public interface RestaurantService {
    void saveRestaurant(Restaurant restaurant);

    Restaurant fetchByRestaurantEmail(String email);

    List<Restaurant> fetchAllRestaurants();


    List<Restaurant> fetchRestaurantsByRole(Role role);
}

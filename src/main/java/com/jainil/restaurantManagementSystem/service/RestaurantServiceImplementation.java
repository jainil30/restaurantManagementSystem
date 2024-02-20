package com.jainil.restaurantManagementSystem.service;


import com.jainil.restaurantManagementSystem.entity.Restaurant;
import com.jainil.restaurantManagementSystem.entity.Role;
import com.jainil.restaurantManagementSystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImplementation implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurant.setRole(Role.ROLE_RESTAURANT);
        restaurantRepository.save(restaurant);
        System.out.println("Saved " + restaurant.toString());
    }

    @Override
    public Restaurant fetchByRestaurantEmail(String email) {
        return this.restaurantRepository.findByRestaurantEmail(email);
    }

    @Override
    public List<Restaurant> fetchAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> fetchRestaurantsByRole(Role role) {
        return this.restaurantRepository.findByRole(role);
    }


}

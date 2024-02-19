package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantEmail(String email);
}

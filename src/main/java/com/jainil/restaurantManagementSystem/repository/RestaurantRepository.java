package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.Restaurant;
import com.jainil.restaurantManagementSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantEmail(String email);

    List<Restaurant> findByRole(Role role);
}

package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String cityName);
}

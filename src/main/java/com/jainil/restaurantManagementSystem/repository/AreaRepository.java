package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByAreaCityName(String selectedCity);
}

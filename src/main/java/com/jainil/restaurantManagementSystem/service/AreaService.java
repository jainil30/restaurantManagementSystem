package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> fetchAllAreas();

    void saveArea(Area area);

    Area fetchAreaById(Long aLong);

    void update(Long id, Area area);

    void deleteArea(Long id);

    List<Area> fetchAreasByCity(String selectedCity);
}

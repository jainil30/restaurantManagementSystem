package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.City;

import java.util.List;

public interface CityService {
    List<City> fetchAllCities();

    void saveCity(City city);

    City fetchCityById(Long id);


    void update(Long aLong, City city);

    void deleteCity(Long id);
}

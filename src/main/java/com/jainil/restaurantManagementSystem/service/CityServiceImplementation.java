package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.City;
import com.jainil.restaurantManagementSystem.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityServiceImplementation implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> fetchAllCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public void saveCity(City city) {
        this.cityRepository.save(city);
    }

    @Override
    public City fetchCityById(Long id) {

        Optional<City> city = this.cityRepository.findById(id);
        return city.orElse(null);
    }
//
//    @Override
//    public City fetchCityByCityName(String cityName) {
//        return this.cityRepository.findByCityName(cityName);
//    }

    @Override
    public void update(Long id, City city) {
        City cityDb = cityRepository.findById(id).get();

            if(Objects.nonNull(city.getCityName()) && !"".equals(city.getCityName())){
                System.out.println("Updating city name");
                cityDb.setCityName(city.getCityName());
            }

            if(Objects.nonNull(city.getCityDescription()) && !"".equals(city.getCityDescription())){
                System.out.println("Updating city Description");

                cityDb.setCityDescription(city.getCityDescription());

            }

            cityRepository.save(cityDb);
    }

    @Override
    public void deleteCity(Long id) {
        this.cityRepository.deleteById(id);
    }
}

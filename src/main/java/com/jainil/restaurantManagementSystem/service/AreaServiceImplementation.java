package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Area;
import com.jainil.restaurantManagementSystem.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AreaServiceImplementation implements AreaService{
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> fetchAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public void saveArea(Area area) {
        this.areaRepository.save(area);
    }

    @Override
    public Area fetchAreaById(Long id) {
        return this.areaRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Area area) {
        Area areaDb = areaRepository.findById(id).get();

        if(Objects.nonNull(area.getAreaCityName()) && !"".equals(area.getAreaCityName())){
            areaDb.setAreaCityName(area.getAreaCityName());
        }

        if(Objects.nonNull(area.getAreaName()) && !"".equals(area.getAreaName())){
            areaDb.setAreaName(area.getAreaName());
        }

        if(Objects.nonNull(area.getAreaDescription()) && !"".equals(area.getAreaDescription())){
            areaDb.setAreaDescription(area.getAreaDescription());
        }

        areaRepository.save(areaDb);

    }

    @Override
    public void deleteArea(Long id) {
        this.areaRepository.deleteById(id);
    }

    @Override
    public List<Area> fetchAreasByCity(String selectedCity) {
        return this.areaRepository.findByAreaCityName(selectedCity);
    }
}

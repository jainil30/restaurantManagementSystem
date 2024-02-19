package com.jainil.restaurantManagementSystem.controller;


import com.jainil.restaurantManagementSystem.entity.Area;
import com.jainil.restaurantManagementSystem.repository.AreaRepository;
import com.jainil.restaurantManagementSystem.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {
    private final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AreaService areaService;

    @GetMapping("/areas/{selectedCity}")
    public List<Area> getAreasByCity(@PathVariable String selectedCity) {
        LOGGER.info("getAreasByCity() is called");
        System.out.println("getAreasByCity() is called");
//        areaService.fetchAreasByCity(selectedCity).forEach(System.out::println);
        return areaService.fetchAreasByCity(selectedCity);
    }
}

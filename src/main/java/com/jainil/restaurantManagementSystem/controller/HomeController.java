package com.jainil.restaurantManagementSystem.controller;

import com.jainil.restaurantManagementSystem.entity.*;
import com.jainil.restaurantManagementSystem.service.AreaService;
import com.jainil.restaurantManagementSystem.service.CityService;
import com.jainil.restaurantManagementSystem.service.ComplaintService;
import com.jainil.restaurantManagementSystem.service.RestaurantService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AreaService areaService;
    private final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/login")
    public String showLoginPage(){
        LOGGER.info("showLoginPage() Called");
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        LOGGER.info("showRegisterPage() Called");
        List<City> cityList = cityService.fetchAllCities();
        List<Area> areaList = areaService.fetchAllAreas();

        model.addAttribute("cities",cityList);
        model.addAttribute("areas",areaList);

        return "register";
    }

//    @PostMapping("/loginUser")
//    public String login(@RequestParam() String email, @RequestParam() String password, HttpSession httpSession){
//        Restaurant restaurant = restaurantService.fetchByRestaurantEmail(email);
//        System.out.println("Fetched resturant : " + restaurant.toString());
//        httpSession.setAttribute("email",email);
//        if(email.equals(restaurant.getRestaurantEmail()) && password.equals(restaurant.getRestaurantPassword())){
//
//            if(restaurant.getRole().equals(Role.ROLE_ADMIN)){
//                return "redirect:/admin/adminDashboard";
//            }else{
//                return "redirect:/restaurant/restaurantDashboard";
//            }
//
//        }else
//            return "redirect:/login";
//
//    }




    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        System.out.println("Logout User : " + httpSession.getAttribute("email"));
        httpSession.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/registerRestaurant")
    public String registerUser(@ModelAttribute Restaurant restaurant, @RequestParam("restaurantPassword") String restaurantPassword, @RequestParam("confirmPassword") String confirmPassword,Model model) {
//        restaurant.setRole(Role.ROLE_RESTAURANT);
        System.out.println("Registering : " + restaurant.toString());
        if(!restaurantPassword.equals(confirmPassword)){
            System.out.println(restaurantPassword + " != "+ confirmPassword);
            System.out.println("new pass and conform pass does not match");
            model.addAttribute("errorMessage", "New passwords do not match.");
            return "redirect:/register?error=1";
        }else{
            restaurant.setRestaurantPassword(bCryptPasswordEncoder.encode(restaurant.getRestaurantPassword()));
            restaurantService.saveRestaurant(restaurant);

            return "redirect:/login?registration=1";
        }



    }


}

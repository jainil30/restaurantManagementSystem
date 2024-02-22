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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

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
//        model.addAttribute("restaurant", new Restaurant());
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
    public String registerUser(@ModelAttribute Restaurant restaurant, @RequestParam("restaurantPassword") String restaurantPassword, @RequestParam("confirmPassword") String confirmPassword, Model model) {  //, BindingResult bindingResult) {
//        restaurant.setRole(Role.ROLE_RESTAURANT);
        System.out.println("Registering : " + restaurant.toString());
        if (!restaurantPassword.equals(confirmPassword)) {
            System.out.println(restaurantPassword + " != " + confirmPassword);
            System.out.println("new pass and conform pass does not match");
            model.addAttribute("errorMessage", "New passwords do not match.");
            return "redirect:/register?error=1";
        } else {

            if(Objects.nonNull(restaurant.getRestaurantEmail())){
                System.out.println("Email --->  : " + restaurant.getRestaurantEmail());
            }


            if (!Objects.nonNull(restaurant.getRestaurantEmail()) || "".equals(restaurant.getRestaurantEmail())) {
                return "redirect:/register?error=Email_cannot_be_empty";
            }else {
                if(Pattern.matches("/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$/", restaurant.getRestaurantEmail())){
                    return "redirect:/register?error=Email_cannot_be_empty";
                }
            }

            if (!Objects.nonNull(restaurant.getRestaurantAddress()) || "".equals(restaurant.getRestaurantAddress())) {
                return "redirect:/register?error=Address_cannot_be_empty";
            }

            if (!Objects.nonNull(restaurant.getRestaurantPassword()) || "".equals(restaurant.getRestaurantPassword())) {
                return "redirect:/register?error=Password_cannot_be_empty";
            }

            if (!Objects.nonNull(restaurant.getRestaurantArea()) || "".equals(restaurant.getRestaurantArea())) {
                return "redirect:/register?error=Area_cannot_be_empty";
            }

            if (!Objects.nonNull(restaurant.getRestaurantCity()) || "".equals(restaurant.getRestaurantCity())) {
                return "redirect:/register?error=City_cannot_be_empty";
            }

            if (!Objects.nonNull(restaurant.getRestaurantName()) || "".equals(restaurant.getRestaurantName())) {
                return "redirect:/register?error=Name_cannot_be_empty";
            }
//            else{
//                if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", restaurant.getRestaurantName())){
//                    return "redirect:/register?error=Restaurant_Name_cannot_be_empty";
//                }
//            }
//        if(bindingResult.hasErrors()){
//            System.out.println("has errors");
//            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.toString()));
//        }


            restaurant.setRestaurantPassword(bCryptPasswordEncoder.encode(restaurant.getRestaurantPassword()));
            restaurantService.saveRestaurant(restaurant);

            return "redirect:/login?registration=1";
        }
    }


}

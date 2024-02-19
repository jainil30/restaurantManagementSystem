package com.jainil.restaurantManagementSystem.config;

import com.jainil.restaurantManagementSystem.entity.Restaurant;
import com.jainil.restaurantManagementSystem.exception.RestaurantNotFoundException;
import com.jainil.restaurantManagementSystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantDetailService implements UserDetailsService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username : " + username);

        Restaurant restaurant = restaurantRepository.findByRestaurantEmail(username);

        if(restaurant == null){
            throw new RestaurantNotFoundException(username + " not found");
        }

        RestaurantDetail restaurantDetail = new RestaurantDetail(restaurant);



        return restaurantDetail;
    }
}

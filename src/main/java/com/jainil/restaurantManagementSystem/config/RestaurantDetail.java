package com.jainil.restaurantManagementSystem.config;

import com.jainil.restaurantManagementSystem.entity.Restaurant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class RestaurantDetail implements UserDetails {
    private Restaurant restaurant;

    public RestaurantDetail(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(restaurant.getRole().toString());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return restaurant.getRestaurantPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("Get Username : " + restaurant.getRestaurantEmail());
        return restaurant.getRestaurantEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

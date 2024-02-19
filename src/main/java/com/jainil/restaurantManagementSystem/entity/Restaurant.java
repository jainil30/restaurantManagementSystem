package com.jainil.restaurantManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_restaurant")
@Data
@NoArgsConstructor
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    private String restaurantName;
    private String restaurantEmail;

    private String restaurantPassword;

    @Enumerated(EnumType.STRING)
    private Role role;
    private Long restaurantContactNo;
    private String restaurantAddress;
    private String restaurantCity;
    private String restaurantArea;

    public Restaurant(String restaurantName, String restaurantEmail, String restaurantPassword, Role role, Long restaurantContactNo, String restaurantAddress, String restaurantCity, String restaurantArea) {
        this.restaurantName = restaurantName;
        this.restaurantEmail = restaurantEmail;
        this.restaurantPassword = restaurantPassword;
        this.role = role;
        this.restaurantContactNo = restaurantContactNo;
        this.restaurantAddress = restaurantAddress;
        this.restaurantCity = restaurantCity;
        this.restaurantArea = restaurantArea;
    }
}

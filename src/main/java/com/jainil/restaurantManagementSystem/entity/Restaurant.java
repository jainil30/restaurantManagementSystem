package com.jainil.restaurantManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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


    @NotNull(message = "Restaurant Name cannot be null")
    @NotEmpty(message = "Restaurant Name cannot be empty")
    @Size(min = 6, message = "Please provide your valid Username Minimum Six characters, at least one uppercase letter, one lowercase letter and one number ")
    private String restaurantName;

    @NotEmpty(message = "Email is mandatory to enter")
    @Email(message = "Invalid email address")
    private String restaurantEmail;

    @NotEmpty(message = "Password is mandatory to enter")
    private String restaurantPassword;

    @Enumerated(EnumType.STRING)
    private Role role;


//    @NotEmpty(message = "Contact number is mandatory")
    @Digits(message = "10 Digits is must", integer = 10, fraction = 0)
    private Long restaurantContactNo;

    @NotEmpty(message = "Address is mandatory to enter")
    private String restaurantAddress;

    @NotEmpty(message = "City is mandatory to enter")
    private String restaurantCity;

    @NotEmpty(message = "Area is mandatory to enter")
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

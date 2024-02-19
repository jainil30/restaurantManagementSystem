package com.jainil.restaurantManagementSystem.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_product")
public class Product {

    /*
    		- ProductId
		- CategoryName
		- SubCategoryName
		- Product Name
		- Product Price
		- Product Description
		- Product Image
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productCategoryName;
    private String productSubCategoryName;
    private String productName;
    private String productPrice;
    private String productDescription;
    private String productImageUrl;
    private String productRestaurant;

}

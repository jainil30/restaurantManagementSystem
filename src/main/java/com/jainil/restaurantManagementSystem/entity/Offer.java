package com.jainil.restaurantManagementSystem.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_offer")
public class Offer {
    /*
    		- OfferId
		- CategoryName
		- SubCategoryName
		- Offer Name
		- Offer Description
		- Start Date
		- End Date
		- Discount (%)
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private String offerRestaurant;
    private String offerCategoryName;
    private String offerSubCategoryName;
    private String offerName;
    private String offerDescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date offerStartDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date offerEndDate;

    private Float offerDiscount;


}

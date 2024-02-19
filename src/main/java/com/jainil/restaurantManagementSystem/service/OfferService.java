package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> fetchAllOffers();

    void saveOffer(Offer offer);

    Offer fetchOfferById(Long id);

    void updateOffer(Long id,Offer offer);

    void deleteOffer(Long offerId);

    List<Offer> fetchAllOffersByRestaurant(String email);
}

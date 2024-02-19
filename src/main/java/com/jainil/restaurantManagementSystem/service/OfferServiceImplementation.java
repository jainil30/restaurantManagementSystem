package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Offer;
import com.jainil.restaurantManagementSystem.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OfferServiceImplementation implements OfferService{
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> fetchAllOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public void saveOffer(Offer offer) {
        this.offerRepository.save(offer);
    }

    @Override
    public Offer fetchOfferById(Long id) {
        return this.offerRepository.findById(id).get();
    }

    @Override
    public void updateOffer(Long id, Offer offer) {
        Offer offerDb = offerRepository.findById(id).get();

        if(Objects.nonNull(offer.getOfferDiscount()) && !"".equals(offer.getOfferDiscount())){
            offerDb.setOfferDiscount(offer.getOfferDiscount());
        }

        if(Objects.nonNull(offer.getOfferDescription()) && !"".equals(offer.getOfferDescription())){
            offerDb.setOfferDescription(offer.getOfferDescription());
        }

        if(Objects.nonNull(offer.getOfferName()) && !"".equals(offer.getOfferName())){
            offerDb.setOfferName(offer.getOfferName());
        }

        if(Objects.nonNull(offer.getOfferCategoryName()) && !"".equals(offer.getOfferCategoryName())){
            offerDb.setOfferCategoryName(offer.getOfferCategoryName());
        }

        if(Objects.nonNull(offer.getOfferSubCategoryName()) && !"".equals(offer.getOfferSubCategoryName())){
            offerDb.setOfferSubCategoryName(offer.getOfferSubCategoryName());
        }

        if(Objects.nonNull(offer.getOfferStartDate()) && !"".equals(offer.getOfferStartDate())){
            offerDb.setOfferStartDate(offer.getOfferStartDate());
        }

        if(Objects.nonNull(offer.getOfferEndDate()) && !"".equals(offer.getOfferEndDate())){
            offerDb.setOfferEndDate(offer.getOfferEndDate());
        }

        offerRepository.save(offerDb);

    }

    @Override
    public void deleteOffer(Long offerId) {
        this.offerRepository.deleteById(offerId);
    }

    @Override
    public List<Offer> fetchAllOffersByRestaurant(String email) {
        return this.offerRepository.findByOfferRestaurant(email);
    }
}

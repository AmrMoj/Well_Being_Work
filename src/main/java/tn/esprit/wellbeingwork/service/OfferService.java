package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();

    Offer addOffer(Offer offer);

    void deleteOffer(Long id);

    Offer updateOffer(Offer offer);

    Offer getOffer(Long id);

}

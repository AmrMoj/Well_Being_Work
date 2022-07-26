package tn.esprit.wellbeingwork.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Offer;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.OfferRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.OfferService;
import tn.esprit.wellbeingwork.service.OfferService;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer addOffer(Offer offer) {

        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer getOffer(Long id) {
        return offerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Offer doesnt exists"));
    }


}

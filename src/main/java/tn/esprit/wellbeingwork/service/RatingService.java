package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();

    Rating addRating(Rating rating);

    void deleteRating(Long id);

    Rating updateRating(Rating rating);

    Rating retrieveRating(Long id);

    List<Rating> getRatingByUser();

}

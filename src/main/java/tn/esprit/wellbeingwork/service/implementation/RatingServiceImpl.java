package tn.esprit.wellbeingwork.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Rating;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.RatingRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.RatingService;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating addRating(Rating rating) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalStateException("User doesnt exists"));
        rating.setUsers(Arrays.asList(user));
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating retrieveRating(Long id) {
        return ratingRepository.findById(id).orElseThrow(() -> new IllegalStateException("Rating doesnt exists"));
    }

    @Override
    public List<Rating> getRatingByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalStateException("User doesnt exists"));
        return ratingRepository.findByUsers(user);
    }
}

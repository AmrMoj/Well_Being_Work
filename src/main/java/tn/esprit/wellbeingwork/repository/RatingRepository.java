package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.entity.Rating;
import tn.esprit.wellbeingwork.entity.User;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    public List<Rating> findByUsers(User user);

}

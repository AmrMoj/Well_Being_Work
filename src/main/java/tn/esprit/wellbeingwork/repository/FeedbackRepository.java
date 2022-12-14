package tn.esprit.wellbeingwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Feedback;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}

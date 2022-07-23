package tn.esprit.wellbeingwork.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.wellbeingwork.entity.Feedback;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */

public interface FeedbackService {
    List<Feedback> getFeedbacks();

    Feedback addFeedback(Feedback feedback);

 Feedback getFeedback(Long id);

    void deleteFeedback(Long id);

    Feedback updateFeedback(Feedback feedback);


}

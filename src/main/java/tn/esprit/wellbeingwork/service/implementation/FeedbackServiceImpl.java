package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import tn.esprit.wellbeingwork.entity.Feedback;
import tn.esprit.wellbeingwork.repository.FeedbackRepository;
import tn.esprit.wellbeingwork.service.FeedbackService;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getFeedbacks() {
        List<Feedback> FeedbackList= feedbackRepository.findAll();
        for (Feedback Feedback: FeedbackList){
            log.info("Feedback: "+Feedback);
        }
        return FeedbackList;
    }

    @Override
    public Feedback addFeedback(Feedback Feedback){
        log.info("Adding Feedback: "+ Feedback.getIdFeedback());
        return feedbackRepository.save(Feedback);
    }

    @Override
    public Feedback getFeedback(Long id) {
 //return FeedbackRepository.findById(id).orElseThrow(null);
return null;
    }

    @Override
    public void deleteFeedback(Long id) {
        Feedback Feedback=feedbackRepository.findById(id).orElse(null);
        assert Feedback != null;
        log.info("Deleting Feedback: "+Feedback.getIdFeedback());
        feedbackRepository.deleteById(id);

    }

    @Override
    public Feedback updateFeedback(Feedback Feedback) {
        log.info("Updating Feedback: "+Feedback);
        return feedbackRepository.save(Feedback);
    }


}

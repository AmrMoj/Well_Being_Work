package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import tn.esprit.wellbeingwork.entity.Feedback;
import tn.esprit.wellbeingwork.service.FeedbackService;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@RestController
@RequestMapping("Feedback")
@Api(tags = "Feedback management")
public class FeedbackController {

    @Autowired
    FeedbackService FeedbackService;

    @ApiOperation(value="Add new Feedback")
    @PostMapping("addFeedback")
    public Feedback addFeedback (@RequestBody Feedback Feedback){
        return FeedbackService.addFeedback(Feedback);
    }

    @ApiOperation(value ="Get all Feedbacks")
    @GetMapping("getFeedbacks")
    public List<Feedback> getAllFeedbacks(){
        return FeedbackService.getFeedbacks();
    }

    @ApiOperation(value = "Get Feedback by ID")
    @GetMapping("/getFeedback/{Feedback-id}")
    public Feedback getFeedback(@PathVariable("Feedback-id") long id){
        return FeedbackService.getFeedback(id);
    }

    @ApiOperation(value = "Delete a Feedback")
    @DeleteMapping("deleteFeedback/{Feedback-id}")
    public void deleteFeedback(@PathVariable("Feedback-id") long id){
        FeedbackService.deleteFeedback(id);
    }

    @ApiOperation(value = "Update a Feedback")
    @PutMapping("updateFeedback")
    public Feedback updateFeedback(@RequestBody Feedback Feedback){
        return FeedbackService.updateFeedback(Feedback);
    }

}

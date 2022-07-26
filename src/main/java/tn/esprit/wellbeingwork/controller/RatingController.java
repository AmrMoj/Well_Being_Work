package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Rating;
import tn.esprit.wellbeingwork.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@Api(tags = "Rating management")
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @ApiOperation(value="Add new rating")
    @PostMapping("add-rating")
    public Rating addRating(@RequestBody Rating rating){
        return ratingService.addRating(rating);
    }

    @ApiOperation(value = "Get all ratings")
    @GetMapping("get-all-ratings")
    public List<Rating> retrieveAllRatings(){
        return ratingService.getAllRatings();
    }

    @ApiOperation(value = "Get a rating")
    @GetMapping("get-rating/{ratingId}")
    public Rating retrieveRating(@PathVariable("ratingId") long id){
        return ratingService.retrieveRating(id);
    }
    @ApiOperation(value = "Get a rating by user")
    @GetMapping("get-rating-by-user}")
    public List<Rating> getRatingByUser(){
        return ratingService.getRatingByUser();
    }

    @ApiOperation(value = "Delete a rating")
    @DeleteMapping("delete-rating/{resevationId}")
    public void deleteRating(@PathVariable("resevationId") long id){
        ratingService.deleteRating(id);
    }

    @ApiOperation(value = "Update a rating")
    @PutMapping("update-rating")
    public Rating updateRating(@RequestBody Rating rating){
        return ratingService.updateRating(rating);
    }
}
